package org.practicatrim2.models

import java.io.File

/**
 * Clase que implementa la interfaz [ExportadorDatos] para exportar registros de mantenimiento en formato JSON.
 */
class ExportadorJSON : ExportadorDatos {

    /**
     * Exporta una lista de registros de mantenimiento a un archivo JSON.
     *
     * @param registros Lista de registros de mantenimiento a exportar.
     * @param nombreArchivo Nombre del archivo (sin extensión) donde se guardarán los datos.
     * @return El contenido del archivo JSON como una cadena de texto.
     */
    override fun exportar(registros: List<RegistroMantenimiento>, nombreArchivo: String): String {
        val contenido = registros.joinToString(prefix = "[", postfix = "]") {
            "{\"ID\":\"${it.brazoId}\",\"Robot\":\"$${it.id}\",\"fecha\":\"${it.fecha}\", \"descripcion\":\"${it.descripcion}\"}"
        }
        File("$nombreArchivo.json").writeText(contenido)
        return contenido
    }
}