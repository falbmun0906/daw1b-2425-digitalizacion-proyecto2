package org.practicatrim2.models

import java.time.LocalDateTime

/**
 * Clase que representa un registro de mantenimiento realizado en un brazo robótico.
 *
 * @property id El identificador único del registro de mantenimiento.
 * @property brazoId El identificador o nombre del brazo robótico al que se le realizó el mantenimiento.
 * @property fecha La fecha y hora en la que se realizó el mantenimiento.
 * @property descripcion Descripción del mantenimiento realizado.
 */
data class RegistroMantenimiento(
    val id: String,
    val brazoId: String,  // Agregado para almacenar el ID o nombre del robot
    val fecha: LocalDateTime,
    val descripcion: String
)