package org.practicatrim2.models

import java.io.File

/**
 * Clase que implementa la exportación de registros de mantenimiento a un archivo CSV.
 */
class ExportadorCSV : ExportadorDatos {

    /**
     * Exporta una lista de registros de mantenimiento a un archivo CSV.
     *
     * El formato del archivo será: brazoId,id,fecha,descripcion
     *
     * @param registros Lista de registros de mantenimiento a exportar.
     * @param nombreArchivo Nombre del archivo (sin extensión) donde se guardarán los datos.
     * @return El contenido del archivo CSV como una cadena de texto.
     */
    override fun exportar(registros: List<RegistroMantenimiento>, nombreArchivo: String): String {
        // Modificamos para incluir 'brazoId' y 'descripcion' en la exportación
        val contenido = registros.joinToString("\n") {
            "${it.brazoId},${it.id},${it.fecha},${it.descripcion}"
        }

        // Escribir el contenido en el archivo CSV
        File("$nombreArchivo.csv").writeText(contenido)
        return contenido
    }
}