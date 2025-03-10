package org.practicatrim2

import org.practicatrim2.view.*
import org.practicatrim2.models.*
import org.practicatrim2.viewmodels.MantenimientoViewModel
import kotlin.math.round
import kotlin.random.Random

/**
 * Redondea un número a dos decimales.
 *
 * Esta función toma un valor numérico genérico (ya sea de tipo `Double` o `Float`) y lo redondea
 * a dos decimales. Si el valor no es de un tipo soportado (es decir, si no es `Double` ni `Float`),
 * lanzará una excepción `IllegalArgumentException`.
 *
 * @param valor El valor numérico que se desea redondear. Este puede ser de tipo `Double` o `Float`.
 * @return El valor redondeado a dos decimales como un `Double`.
 * @throws IllegalArgumentException Si el tipo de valor no es soportado.
 *
 * @sample
 * // Ejemplo de uso:
 * val resultado = redondearADosDecimales(3.14159)
 * println(resultado) // Imprime: 3.14
 */
fun <T : Number> redondearADosDecimales(valor: T): Double {
    return when (valor) {
        is Double -> (round(valor * 100.0) / 100.0)
        is Float -> (round(valor * 100.0) / 100.0).toDouble()
        else -> throw IllegalArgumentException("Tipo no soportado")
    }
}

/**
 * Genera un nombre único para un robot.
 *
 * El nombre se compone de un prefijo aleatorio, un sufijo aleatorio y un número aleatorio entre 100 y 999.
 *
 * @return El nombre generado para el robot en el formato "Prefijo-Sufijo-###".
 */
fun generarNombreRobot(): String {
    val prefijos = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
    val sufijos = listOf("X", "Y", "Z", "Q", "W")
    return "${prefijos.random()}-${sufijos.random()}-${Random.nextInt(100, 999)}"
}

/**
 * Genera una lista de motores aleatorios que incluye un `MotorServo` y un `MotorPasoAPaso`.
 *
 * Los motores se crean con propiedades aleatorias como el ID, nombre, RPM y potencia.
 *
 * @return Una lista de motores aleatorios.
 */
fun generarMotoresAleatorios(): List<Motor> {
    return listOf(
        MotorServo(
            id = Random.nextInt(1, 100).toString(),
            nombre = "Servo-${Random.nextInt(100, 999)}",
            rpm = Random.nextInt(500, 1500),
            potencia = Random.nextDouble(100.0, 500.0),
            angulo = Random.nextDouble(0.0, 90.0)
        ),
        MotorPasoAPaso(
            id = Random.nextInt(1, 100).toString(),
            nombre = "PasoAPaso-${Random.nextInt(100, 999)}",
            rpm = Random.nextInt(500, 1500),
            potencia = Random.nextDouble(100.0, 500.0),
            pasosPorRevolucion = Random.nextInt(100, 500)
        )
    )
}

/**
 * Genera una lista de sensores aleatorios, que incluyen sensores de tipo temperatura, presión y vibración.
 *
 * Cada sensor se genera con un ID único y un valor aleatorio dentro de un rango específico.
 *
 * @return Una lista de sensores aleatorios.
 */
fun generarSensoresAleatorios(): List<Sensor> {
    return listOf(
        SensorTemperatura(id = "T${Random.nextInt(1, 100)}", valor = Random.nextDouble(20.0, 100.0)),
        SensorPresion(id = "P${Random.nextInt(1, 100)}", valor = Random.nextDouble(1.0, 10.0)),
        SensorVibracion(id = "V${Random.nextInt(1, 100)}", valor = Random.nextDouble(0.5, 5.0))
    )
}

/**
 * Genera un brazo robótico aleatorio, que incluye un nombre único, motores y sensores.
 *
 * El brazo tiene un nombre generado aleatoriamente, junto con una lista de motores y sensores aleatorios.
 *
 * @return Un brazo robótico aleatorio con motores y sensores generados aleatoriamente.
 */
fun generarBrazoRobotico(): BrazoRobotico {
    val nombre = generarNombreRobot()
    val motores = generarMotoresAleatorios()
    val sensores = generarSensoresAleatorios()
    return BrazoRobotico(id = Random.nextInt(1, 100).toString(), nombre = nombre, motores = motores, sensores = sensores)
}

/**
 * Función principal que genera una lista de brazos robóticos y permite la interacción con el usuario.
 *
 * Se genera una lista de 3 brazos robóticos, se cargan los protocolos desde un archivo JSON,
 * y se muestra un menú para que el usuario pueda interactuar con el sistema.
 *
 * @param args Argumentos de la línea de comandos (no utilizados).
 */
fun main() {
    val brazos = List(3) { generarBrazoRobotico() }
    val protocolos = cargarProtocolos("src/main/resources/protocolos.json")
    val viewModel = MantenimientoViewModel(brazos)

    mostrarMenu(brazos, protocolos, viewModel)
}
