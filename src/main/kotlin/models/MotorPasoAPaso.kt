package org.practicatrim2.models

import org.practicatrim2.redondearADosDecimales

/**
 * Clase que representa un motor paso a paso, que es un tipo específico de motor utilizado en los brazos robóticos.
 *
 * @property pasosPorRevolucion El número de pasos que realiza el motor por cada revolución completa.
 * @param id El identificador único del motor.
 * @param nombre El nombre del motor.
 * @param rpm Revoluciones por minuto del motor.
 * @param potencia La potencia del motor en vatios (Watts).
 */
class MotorPasoAPaso(
    id: String,
    nombre: String,
    rpm: Int,
    potencia: Double,
    val pasosPorRevolucion: Int
) : Motor(id, nombre, rpm, potencia) {

    /**
     * Calcula el consumo de energía del motor paso a paso.
     *
     * El consumo de energía se calcula en función de la potencia del motor y la cantidad de pasos por revolución.
     * La fórmula utilizada es:
     * `consumo = potencia * pasosPorRevolucion / 200.0`.
     *
     * @return El consumo de energía en vatios (Watts).
     */
    override fun calcularConsumoEnergia(): Double {
        return redondearADosDecimales(potencia * pasosPorRevolucion / 200.0)
    }
}