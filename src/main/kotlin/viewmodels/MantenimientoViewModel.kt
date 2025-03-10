package org.practicatrim2.viewmodels

import org.practicatrim2.models.*
import java.time.LocalDateTime
import java.io.File
import java.io.IOException

/**
 * ViewModel para gestionar el mantenimiento de los brazos robóticos.
 * Proporciona métodos para registrar mantenimientos, obtener sensores críticos,
 * predecir fallos en motores y exportar los registros de mantenimiento a archivos.
 *
 * @param brazosRoboticos Lista de brazos robóticos que gestionará este ViewModel.
 */
class MantenimientoViewModel(private val brazosRoboticos: List<BrazoRobotico>) {

    /**
     * Registra un mantenimiento para un brazo específico.
     * Se crea un registro con un ID único basado en el tiempo actual y la descripción proporcionada.
     *
     * @param brazoSeleccionado Brazo robótico para el que se registrará el mantenimiento.
     * @param descripcion Descripción del mantenimiento que se va a registrar.
     */
    fun registrarMantenimiento(brazoSeleccionado: BrazoRobotico, descripcion: String) {
        // Crear un registro de mantenimiento con el ID del robot incluido
        val registro = RegistroMantenimiento(
            id = "R${System.currentTimeMillis()}",  // ID único para el registro
            brazoId = brazoSeleccionado.id,  // Incluir el ID o nombre del robot
            fecha = LocalDateTime.now(),
            descripcion = descripcion
        )
        // Agregar el registro al brazo seleccionado
        brazoSeleccionado.agregarRegistro(registro)
    }

    /**
     * Obtiene todos los sensores críticos de todos los brazos robóticos.
     * Un sensor es considerado crítico si cumple con los criterios definidos en su clase.
     *
     * @return Lista de sensores críticos encontrados en todos los brazos robóticos.
     */
    fun obtenerSensoresCriticos(): List<Sensor> {
        return brazosRoboticos.flatMap { brazo ->
            brazo.sensores.filter { it.esCritico() }
        }
    }

    /**
     * Predice posibles fallos en los motores de todos los brazos robóticos.
     * Los fallos se predicen si el RPM de un motor es crítico o si el consumo de energía excede el umbral definido.
     *
     * @return Lista de pares que contienen el brazo robótico y el motor donde se predijo un fallo.
     */
    fun predecirFalloMotores(): List<Pair<BrazoRobotico, Motor>> {
        val fallos = mutableListOf<Pair<BrazoRobotico, Motor>>()
        brazosRoboticos.forEach { brazo ->
            brazo.motores.forEach { motor ->
                if (Motor.esRpmCritica(motor.rpm) || motor.calcularConsumoEnergia() > 500) {
                    fallos.add(Pair(brazo, motor))
                }
            }
        }
        return fallos
    }

    /**
     * Exporta los registros de mantenimiento de todos los brazos robóticos a un archivo.
     * El tipo de archivo puede ser CSV o JSON, dependiendo del exportador utilizado.
     *
     * @param exportador Objeto que define el método de exportación de los registros.
     * @param nombreArchivo Nombre base del archivo donde se exportarán los registros.
     * @return El contenido exportado como un String.
     */
    fun exportarRegistros(exportador: ExportadorDatos, nombreArchivo: String): String {
        // Exportar registros de todos los brazos
        val contenido = exportador.exportar(brazosRoboticos.flatMap { it.registros }, nombreArchivo)

        // Crear archivo con el nombre adecuado según el tipo de exportador
        val extension = if (exportador is ExportadorCSV) "csv" else "json"
        val archivo = File("$nombreArchivo.$extension")

        return try {
            // Escribir el contenido al archivo
            archivo.writeText(contenido)
            println("Archivo exportado correctamente: ${archivo.absolutePath}")
            contenido
        } catch (e: IOException) {
            // Manejo de errores al escribir el archivo
            println("Error al exportar el archivo: ${e.message}")
            ""
        }
    }
}