package org.practicatrim2.models

import org.practicatrim2.redondearADosDecimales

/**
 * Clase que representa un motor servo, un tipo de motor utilizado en los brazos robóticos para controlar el movimiento de forma precisa.
 *
 * @property angulo El ángulo que puede alcanzar el motor servo en grados.
 * @param id El identificador único del motor.
 * @param nombre El nombre del motor.
 * @param rpm Revoluciones por minuto del motor.
 * @param potencia La potencia del motor en vatios (Watts).
 */
class MotorServo(
    id: String,
    nombre: String,
    rpm: Int,
    potencia: Double,
    val angulo: Double // en grados
) : Motor(id, nombre, rpm, potencia) {

    /**
     * Calcula el consumo de energía del motor servo.
     *
     * El consumo de energía se calcula en función de la potencia del motor y las revoluciones por minuto (rpm).
     * La fórmula utilizada es:
     * `consumo = potencia * (rpm / 1000.0)`.
     *
     * @return El consumo de energía en vatios (Watts).
     */
    override fun calcularConsumoEnergia(): Double {
        return redondearADosDecimales(potencia * (rpm / 1000.0))
    }
}