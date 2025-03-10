package org.practicatrim2.models

/**
 * Representa una alerta generada en el sistema, con un mensaje descriptivo y un nivel de severidad asociado.
 *
 * @property mensaje El contenido o descripción de la alerta.
 * @property severidad El nivel de severidad de la alerta, definido por la enumeración [Severidad].
 */
data class Alerta(
    val mensaje: String,
    val severidad: Severidad
)
