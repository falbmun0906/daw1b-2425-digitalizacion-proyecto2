package org.practicatrim2.models

/**
 * Enum que representa los diferentes niveles de severidad para una condición o fallo en el sistema.
 *
 * Los niveles de severidad pueden ser utilizados para categorizar la gravedad de los eventos,
 * fallos o condiciones que se detectan en los brazos robóticos, sensores o motores.
 *
 * @property ALTA Representa un nivel de severidad alto.
 * @property MEDIA Representa un nivel de severidad medio.
 * @property BAJA Representa un nivel de severidad bajo.
 */
enum class Severidad {
    ALTA,
    MEDIA,
    BAJA
}
