package org.practicatrim2.models

/**
 * Interfaz que define el contrato para exportar registros de mantenimiento a distintos formatos.
 */
interface ExportadorDatos {

    /**
     * Exporta una lista de registros de mantenimiento a un archivo con el formato definido por la implementación.
     *
     * @param registros Lista de registros de mantenimiento a exportar.
     * @param nombreArchivo Nombre del archivo (sin extensión) donde se guardarán los datos.
     * @return El contenido del archivo exportado como una cadena de texto.
     */
    fun exportar(registros: List<RegistroMantenimiento>, nombreArchivo: String): String
}