package org.practicatrim2.models

import org.practicatrim2.redondearADosDecimales

/**
 * Clase que representa un sensor de vibración en un brazo robótico.
 *
 * Esta clase extiende la clase abstracta [Sensor] y define el comportamiento específico para un sensor de vibración.
 * El sensor será crítico si el valor medido supera un umbral de vibración de 2.0.
 *
 * @property id El identificador único del sensor de vibración.
 * @property valor El valor de vibración medido por el sensor.
 */
class SensorVibracion(id: String, valor: Double) : Sensor(id, "Vibración", redondearADosDecimales(valor)) {

    /**
     * Determina si el valor de vibración medido por el sensor es crítico.
     *
     * El sensor se considera crítico si el valor medido es mayor a 2.0.
     *
     * @return `true` si el valor de vibración es mayor que 2.0, `false` en caso contrario.
     */
    override fun esCritico(): Boolean = valor > 2.0
}