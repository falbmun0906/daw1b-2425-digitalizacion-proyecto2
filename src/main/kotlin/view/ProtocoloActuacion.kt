package org.practicatrim2.view

import kotlinx.serialization.Serializable

/**
 * Representa un protocolo de actuación en caso de fallo de un componente de un brazo robótico.
 * Contiene la descripción del fallo, el protocolo a seguir, herramientas necesarias, acciones a tomar,
 * y el tiempo estimado para realizar el protocolo.
 *
 * @param fallo Descripción del fallo detectado en el sistema (e.g., "Fallo en el motor", "Sensor de temperatura defectuoso").
 * @param protocolo Nombre o identificador del protocolo a seguir ante el fallo.
 * @param descripcion Descripción detallada de lo que implica el protocolo de actuación.
 * @param tiempo_estimado Tiempo estimado para completar el protocolo (puede ser nulo).
 * @param herramientas_necesarias Lista de herramientas necesarias para realizar el protocolo (por defecto está vacío).
 * @param acciones Lista de acciones que deben realizarse para solucionar el fallo (por defecto está vacío).
 */
@Serializable
data class ProtocoloActuacion(
    val fallo: String,
    val protocolo: String,
    val descripcion: String,
    val tiempo_estimado: String? = null,
    val herramientas_necesarias: List<String> = emptyList(),
    val acciones: List<String> = emptyList()
)