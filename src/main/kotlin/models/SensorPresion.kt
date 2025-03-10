package org.practicatrim2.models

import org.practicatrim2.redondearADosDecimales

/**
 * Clase que representa un sensor de presión en un brazo robótico.
 *
 * Esta clase extiende la clase abstracta [Sensor] y define el comportamiento específico para un sensor de presión.
 * El sensor será crítico si el valor medido supera un umbral de presión de 5 unidades.
 *
 * @property id El identificador único del sensor de presión.
 * @property valor El valor de presión medido por el sensor.
 */
class SensorPresion(id: String, valor: Double) : Sensor(id, "Presión", redondearADosDecimales(valor)) {

    /**
     * Determina si el valor de presión medido por el sensor es crítico.
     *
     * El sensor se considera crítico si el valor medido es mayor a 5.
     *
     * @return `true` si el valor de presión es mayor que 5, `false` en caso contrario.
     */
    override fun esCritico(): Boolean = valor > 5
}