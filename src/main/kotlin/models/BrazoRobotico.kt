package org.practicatrim2.models

/**
 * Representa un brazo robótico que contiene motores, sensores y registros de mantenimiento.
 *
 * @property id Identificador único del brazo robótico.
 * @property nombre Nombre del brazo robótico.
 * @property motores Lista de motores asociados al brazo robótico.
 * @property sensores Lista de sensores asociados al brazo robótico.
 * @property registros Lista mutable que almacena los registros de mantenimiento realizados.
 */
data class BrazoRobotico(
    val id: String,
    val nombre: String,
    val motores: List<Motor>,
    val sensores: List<Sensor>,
    val registros: MutableList<RegistroMantenimiento> = mutableListOf()
) {
    /**
     * Añade un nuevo registro de mantenimiento a la lista de registros del brazo robótico.
     *
     * @param registro El registro de mantenimiento a añadir.
     */
    fun agregarRegistro(registro: RegistroMantenimiento) {
        registros.add(registro)
    }
}