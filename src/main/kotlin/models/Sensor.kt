package org.practicatrim2.models

/**
 * Clase abstracta que representa un sensor en un brazo robótico.
 *
 * @property id El identificador único del sensor.
 * @property tipo El tipo de sensor (por ejemplo, temperatura, presión, etc.).
 * @property valor El valor medido por el sensor.
 */
abstract class Sensor(
    val id: String,
    val tipo: String,
    var valor: Double
) {

    /**
     * Función abstracta que determina si el valor del sensor es crítico.
     *
     * Esta función debe ser implementada por las clases que extiendan esta clase para definir cuándo
     * el valor del sensor es considerado crítico (por ejemplo, por encima o por debajo de un umbral).
     *
     * @return `true` si el valor del sensor es crítico, `false` si no lo es.
     */
    abstract fun esCritico(): Boolean
}