package org.practicatrim2.models

/**
 * Clase abstracta que representa un motor de un brazo robótico.
 *
 * @property id El identificador único del motor.
 * @property nombre El nombre del motor.
 * @property rpm Revoluciones por minuto del motor.
 * @property potencia La potencia del motor en vatios (Watts).
 */
abstract class Motor(
    val id: String,
    val nombre: String,
    var rpm: Int,
    val potencia: Double // en Watts
) {

    /**
     * Método abstracto que debe ser implementado por las subclases para calcular el consumo de energía del motor.
     *
     * @return El consumo de energía calculado en función de la implementación específica.
     */
    abstract fun calcularConsumoEnergia(): Double

    companion object {
        const val RPM_MAXIMA = 1200

        /**
         * Función que determina si un motor tiene una RPM crítica.
         *
         * @param rpm Las revoluciones por minuto del motor.
         * @return `true` si las RPM del motor son superiores al valor máximo permitido, `false` en caso contrario.
         */
        fun esRpmCritica(rpm: Int): Boolean = rpm > RPM_MAXIMA
    }
}