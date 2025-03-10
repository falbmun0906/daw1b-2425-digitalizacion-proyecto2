package org.practicatrim2.models

import org.practicatrim2.redondearADosDecimales

/**
 * Clase que representa un sensor de temperatura en un brazo robótico.
 *
 * Esta clase extiende la clase abstracta [Sensor] y define el comportamiento específico para un sensor de temperatura.
 * El sensor será crítico si el valor medido supera un umbral de temperatura de 70 grados.
 *
 * @property id El identificador único del sensor de temperatura.
 * @property valor El valor de temperatura medido por el sensor.
 */
class SensorTemperatura(id: String, valor: Double) : Sensor(id, "Temperatura", redondearADosDecimales(valor)) {

    /**
     * Determina si el valor de temperatura medido por el sensor es crítico.
     *
     * El sensor se considera crítico si el valor medido es mayor a 70 grados.
     *
     * @return `true` si el valor de temperatura es mayor que 70, `false` en caso contrario.
     */
    override fun esCritico(): Boolean = valor > 70
}