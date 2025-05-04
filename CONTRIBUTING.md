# Guía para contribuir al proyecto

¡Gracias por tu interés en contribuir al Sistema de Gestión de Mantenimiento para Brazos Robóticos! Este proyecto busca fomentar la transformación digital en entornos industriales, y cualquier aportación que ayude a mejorarlo es bienvenida.

### ¿Quién puede contribuir?

Este proyecto está orientado tanto a estudiantes como a profesionales que deseen colaborar en una herramienta sencilla pero útil para el sector industrial. No necesitas ser experto en Kotlin, pero se valoran conocimientos básicos en programación y buenas prácticas de desarrollo.

### Tipos de contribuciones aceptadas

Puedes ayudar en muchas formas:

- Corrección de errores.
- Mejora de la documentación (README, comentarios de código, wiki).
- Propuestas de nuevas funciones o mejoras del flujo de trabajo.
- Testeo del software en distintos entornos (Linux, Windows, Mac).
- Sugerencias relacionadas con seguridad y tratamiento de datos.
- Traducciones y adaptación internacional del contenido (inglés, francés, etc.).

### Estructura de ramas

Se sigue un modelo simple:

``main``: Rama principal. Contiene siempre el código estable.

``dev``: Rama de desarrollo activo. Aquí se integran nuevas funciones y mejoras.

``feature/nombre-funcion``: Para nuevas funcionalidades.

``fix/nombre-error``: Para corrección de errores específicos.

### Requisitos técnicos para contribuir

- Tener instalado Kotlin (versión 1.8 o superior).
- Conocer el sistema de construcción Gradle.
- Mantener el estilo de codificación y comentarios del proyecto.
- Comentar tu código usando KDoc para que pueda ser documentado automáticamente.

### Buenas prácticas

- Escribe código claro y documentado.
- Abre una issue si detectas un error o tienes una propuesta, antes de hacer una pull request.
- Haz commits pequeños y descriptivos.
- No subas archivos innecesarios (build, binarios, configuraciones personales).
- Prueba tu código antes de enviarlo para asegurar que no rompe funcionalidades existentes.

### Cómo empezar

- Haz un fork del repositorio.
  
- Crea una rama para tu contribución.

```bash
git checkout -b feature/tu-mejora
```

- Haz tus cambios y añade un mensaje de commit claro.

```bash
git commit -m "Añade alerta visual para robots sin mantenimiento"
```

- Sube los cambios y abre una pull request en GitHub.

```bash
git push origin feature/tu-mejora
```

### Capacitación y aprendizaje

Este repositorio también sirve como punto de partida para aprender:

- Cómo funciona un flujo de trabajo con Git.
- Cómo se documenta software en Kotlin.
- Cómo se construye una pequeña aplicación con buenas prácticas.
- Cómo se colabora en proyectos de código abierto.

### Contacto

Si tienes dudas o necesitas ayuda para empezar, puedes abrir una issue en GitHub. Estaremos encantados de ayudarte a empezar.
