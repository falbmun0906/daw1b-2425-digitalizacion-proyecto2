package org.practicatrim2.view

import org.practicatrim2.models.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.practicatrim2.viewmodels.MantenimientoViewModel
import java.io.File
import java.util.*
import com.github.ajalt.mordant.rendering.*
import com.github.ajalt.mordant.terminal.Terminal
import com.github.ajalt.mordant.rendering.*
import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.TextStyles
import com.github.ajalt.mordant.rendering.TextStyles.bold

/**
 * Carga los protocolos de actuación desde un archivo JSON.
 *
 * @param fileName Nombre del archivo JSON que contiene los protocolos.
 * @return Una lista de protocolos de actuación cargados desde el archivo.
 */
fun cargarProtocolos(fileName: String): List<ProtocoloActuacion> {
    val fileContent = File(fileName).readText()
    return Json.decodeFromString(fileContent)
}

/**
 * Exporta una hoja de actuación con los detalles de los brazos robóticos, motores y sensores.
 * Incluye también los protocolos de actuación para los fallos detectados.
 *
 * @param brazos Lista de brazos robóticos a evaluar.
 * @param protocolos Lista de protocolos de actuación.
 * @param fileName Nombre del archivo en el que se generará la hoja de actuación.
 */
fun exportarHojaActuacion(brazos: List<BrazoRobotico>, protocolos: List<ProtocoloActuacion>, fileName: String) {
    val hoja = buildString {
        append("Hoja de Actuación\n\n")

        brazos.forEach { brazo ->
            append("Brazo: ${brazo.nombre}\n")

            // Evaluar motores
            brazo.motores.forEach { motor ->
                val protocolo = protocolos.find {
                    Regex("(?i).*motor.*|.*sobrecalentamiento.*|.*desgaste.*|.*energía.*").containsMatchIn(it.fallo)
                }

                if (Motor.esRpmCritica(motor.rpm) || motor.calcularConsumoEnergia() > 500) {
                    append("\t- Motor: ${motor.nombre}\n")
                    append("\t\tFallo detectado - Protocolo: ${protocolo?.protocolo ?: "Desconocido"}\n")
                    append("\t\tDescripción: ${protocolo?.descripcion ?: "N/A"}\n")
                    append("\t\tTiempo estimado: ${protocolo?.tiempo_estimado ?: "N/A"}\n")
                    append("\t\tHerramientas necesarias: ${protocolo?.herramientas_necesarias?.joinToString(", ") ?: "N/A"}\n")
                    append("\t\tAcciones:\n")
                    protocolo?.acciones?.forEachIndexed { index, accion ->
                        append("\t\t\t${index + 1}. $accion\n")
                    } ?: append("\t\t\tN/A\n")
                } else {
                    append("\t- Motor: ${motor.nombre} (No requiere actuación)\n")
                }
            }

            // Evaluar sensores
            brazo.sensores.forEach { sensor ->
                val protocolo = protocolos.find {
                    Regex("(?i).*sensor.*|.*comunicación.*|.*desconectado.*|.*presión.*|.*temperatura.*|.*vibración.*").containsMatchIn(it.fallo)
                }

                if (sensor.esCritico()) {
                    append("\t- Sensor: ${sensor.tipo}\n")
                    append("\t\tFallo detectado - Protocolo: ${protocolo?.protocolo ?: "Desconocido"}\n")
                    append("\t\tDescripción: ${protocolo?.descripcion ?: "N/A"}\n")
                    append("\t\tTiempo estimado: ${protocolo?.tiempo_estimado ?: "N/A"}\n")
                    append("\t\tHerramientas necesarias: ${protocolo?.herramientas_necesarias?.joinToString(", ") ?: "N/A"}\n")
                    append("\t\tAcciones:\n")
                    protocolo?.acciones?.forEachIndexed { index, accion ->
                        append("\t\t\t${index + 1}. $accion\n")
                    } ?: append("\t\t\tN/A\n")
                } else {
                    append("\t- Sensor: ${sensor.tipo} (No requiere actuación)\n")
                }
            }
            append("\n")
        }
    }

    // Escribir el archivo
    val file = File(fileName)
    file.writeText(hoja)
    println("Hoja de actuación generada: ${file.absolutePath}")
}

/**
 * Registra un mantenimiento para un brazo robótico específico, solicitando la descripción al usuario.
 *
 * @param brazos Lista de brazos robóticos disponibles para seleccionar.
 * @param viewModel El ViewModel que manejará la lógica del registro del mantenimiento.
 */
fun registrarMantenimiento(brazos: List<BrazoRobotico>, viewModel: MantenimientoViewModel) {
    println("\n🛠️ Registrar Mantenimiento:")

    brazos.forEachIndexed { index, brazo ->
        println("${index + 1}. Brazo: ${brazo.nombre}")
    }
    print("Seleccione el número del brazo a registrar el mantenimiento: ")
    val seleccion = readLine()?.toIntOrNull()

    if (seleccion == null || seleccion !in 1..brazos.size) {
        println("❌ Selección inválida.")
        return
    }

    val brazoSeleccionado = brazos[seleccion - 1]
    print("Ingrese la descripción del mantenimiento: ")
    val descripcion = readLine().orEmpty()

    // Aquí pasamos el brazo y la descripción al ViewModel
    viewModel.registrarMantenimiento(brazoSeleccionado, descripcion)
    println("✅ Mantenimiento registrado para el brazo ${brazoSeleccionado.nombre}.")
}

/**
 * Muestra el menú de opciones para gestionar los brazos robóticos.
 * Permite interactuar con diferentes funciones como mostrar información, generar hoja de actuación,
 * registrar mantenimiento, ver sensores críticos, predecir fallos y exportar registros.
 *
 * @param brazos Lista de brazos robóticos a gestionar.
 * @param protocolos Lista de protocolos de actuación para realizar las tareas.
 * @param viewModel El ViewModel que maneja la lógica del mantenimiento.
 */
fun mostrarMenu(brazos: List<BrazoRobotico>, protocolos: List<ProtocoloActuacion>, viewModel: MantenimientoViewModel) {
    val terminal = Terminal()

    while (true) {
        terminal.println(TextColors.brightBlue(bold("🔧 Menú de Gestión de Brazos Robóticos")))
        terminal.println(bold("1. ") + TextColors.brightGreen("Mostrar información de los brazos"))
        terminal.println(bold("2. ") + TextColors.brightYellow("Generar hoja de actuación"))
        terminal.println(bold("3. ") + TextColors.brightMagenta("Registrar mantenimiento"))
        terminal.println(bold("4. ") + TextColors.brightCyan("Ver sensores críticos"))
        terminal.println(bold("5. ") + TextColors.brightWhite("Predecir fallos en motores"))
        terminal.println(bold("6. ") + TextColors.brightBlue("Exportar registros"))
        terminal.println(bold("7. ") + TextColors.brightRed("Salir"))
        terminal.print(TextColors.brightGreen("\nElige una opción: "))

        when (readlnOrNull()) {
            "1" -> brazos.forEach { brazo ->
                terminal.println("\n🤖 ${TextColors.brightGreen("Brazo Robótico: ${brazo.nombre}")}")
                brazo.motores.forEach { motor ->
                    terminal.println("  - Motor: ${motor.nombre}, RPM: ${motor.rpm}, Consumo: ${motor.calcularConsumoEnergia()}W")
                }
                brazo.sensores.forEach { sensor ->
                    terminal.println("  - Sensor: ${sensor.tipo}, Valor: ${sensor.valor}")
                }
            }
            "2" -> exportarHojaActuacion(brazos, protocolos, "hoja_actuacion.txt")
            "3" -> registrarMantenimiento(brazos, viewModel)
            "4" -> {
                val sensoresCriticos = viewModel.obtenerSensoresCriticos()
                if (sensoresCriticos.isNotEmpty()) {
                    terminal.println("\n🔴 ${TextColors.brightRed("Sensores Críticos:")}")
                    sensoresCriticos.forEach { sensor ->
                        terminal.println("  - Sensor: ${sensor.tipo}, Valor: ${sensor.valor}")
                    }
                } else {
                    terminal.println("No se encontraron sensores críticos.")
                }
            }
            "5" -> {
                val fallos = viewModel.predecirFalloMotores()
                if (fallos.isNotEmpty()) {
                    terminal.println("\n⚠️ ${TextColors.brightYellow("Fallos Predichos en Motores:")}")
                    fallos.forEach { (brazo, motor) ->
                        terminal.println("  - Brazo: ${brazo.nombre}, Motor: ${motor.nombre}, RPM: ${motor.rpm}")
                    }
                } else {
                    terminal.println("No se predijeron fallos en los motores.")
                }
            }
            "6" -> {
                terminal.print("Seleccione el tipo de archivo para exportar (CSV/JSON): ")
                val tipoArchivo = readLine()?.trim()?.lowercase(Locale.getDefault())
                val exportador = when (tipoArchivo) {
                    "csv" -> ExportadorCSV()
                    "json" -> ExportadorJSON()
                    else -> {
                        terminal.println("Tipo de archivo no válido. Seleccionando por defecto CSV.")
                        ExportadorCSV()
                    }
                }
                terminal.print("Ingrese el nombre del archivo: ")
                val nombreArchivo = readLine().orEmpty()
                viewModel.exportarRegistros(exportador, nombreArchivo)
            }
            "7" -> return
            else -> terminal.println("Opción inválida. Intente de nuevo.")
        }
    }
}