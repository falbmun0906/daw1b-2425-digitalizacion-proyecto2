### Criterio 6a) Objetivos estratégicos:
- ¿Qué objetivos estratégicos específicos de la empresa aborda tu software?

El software responde a la necesidad estratégica de reducir el tiempo de inactividad de los brazos robóticos y mejorar la trazabilidad del mantenimiento preventivo y correctivo. También se alinea con el objetivo de RoboLine S.A. de automatizar procesos internos para aumentar la eficiencia operativa.

- ¿Cómo se alinea el software con la estrategia general de digitalización?

La herramienta forma parte del plan de RoboLine S.A. para digitalizar áreas clave del taller de producción, reemplazando registros manuales y hojas de cálculo por una aplicación accesible, estructurada y escalable. Representa un primer paso hacia una plataforma digital más integral para la industria 4.0.

### Criterio 6b) Áreas de negocio y comunicaciones:
- ¿Qué áreas de la empresa (producción, negocio, comunicaciones) se ven más beneficiadas con tu software?

Principalmente se beneficia el área de producción, ya que permite una gestión más precisa del mantenimiento. También se ve beneficiado el departamento técnico y el equipo de supervisión operativa, ya que cuentan con informes organizados y centralizados.

- ¿Qué impacto operativo esperas en las operaciones diarias?

Se espera una reducción en fallos por mantenimiento no realizado a tiempo, una mejor planificación del personal técnico y menos interrupciones en la línea de ensamblaje. Además, se mejora la comunicación entre operarios y técnicos mediante registros más claros.

### Criterio 6c) Áreas susceptibles de digitalización:
- ¿Qué áreas de la empresa son más susceptibles de ser digitalizadas con tu software?

La gestión de activos industriales, en concreto el mantenimiento de brazos robóticos, es una de las áreas más susceptibles. También podrían digitalizarse tareas relacionadas con reportes de fallos, planificación de revisiones periódicas y asignación de tareas.

- ¿Cómo mejorará la digitalización las operaciones en esas áreas?

Permitirá tener historiales de mantenimiento completos, programar alertas automáticas, asignar técnicos de forma dinámica y tomar decisiones basadas en datos reales del uso de los robots. Se reducirá el margen de error humano y se optimizará el rendimiento de los equipos.

### Criterio 6d) Encaje de áreas digitalizadas (AD):
- ¿Cómo interactúan las áreas digitalizadas con las no digitalizadas?

Actualmente, muchas órdenes de reparación o revisiones periódicas aún se comunican verbalmente o por correo. El software propone una solución que se puede complementar con procesos aún manuales, como la ejecución física del mantenimiento, facilitando la transición digital gradual.

- ¿Qué soluciones o mejoras propondrías para integrar estas áreas?

Podría desarrollarse una interfaz web ligera donde el equipo de mantenimiento reciba notificaciones o solicitudes de revisión. También se propone una formación básica al personal de otras áreas para interactuar con el software.

### Criterio 6e) Necesidades presentes y futuras:
- ¿Qué necesidades actuales de la empresa resuelve tu software?

Resuelve la necesidad de tener un sistema centralizado y fiable para registrar, consultar y planificar tareas de mantenimiento. Aporta visibilidad, reduce errores y mejora la coordinación entre técnicos.

### Criterio 6f) Relación con tecnologías:
- ¿Qué tecnologías habilitadoras has empleado y cómo impactan en las áreas de la empresa?

El software utiliza Kotlin como lenguaje base, permitiendo una aplicación multiplataforma sencilla y robusta. Se usa SQLite como sistema de base de datos, ideal para sistemas embebidos. Estas tecnologías permiten construir una app ligera y fácilmente desplegable.

- ¿Qué beneficios específicos aporta la implantación de estas tecnologías?

  - Bajo coste de despliegue y mantenimiento.
  - Flexibilidad para adaptarse a diferentes entornos (taller, oficina técnica).
  - Base sólida para evolucionar hacia una solución web o móvil sin rehacer todo desde cero.

### Criterio 6g) Brechas de seguridad:
- ¿Qué posibles brechas de seguridad podrían surgir al implementar tu software?

Si se despliega en red sin protección, podrían producirse accesos no autorizados a los registros. También existe riesgo si no se validan correctamente los datos introducidos por los usuarios.

- ¿Qué medidas concretas propondrías para mitigarlas?

  - Añadir control de acceso con autenticación básica.
  - Validación de datos tanto en la interfaz como a nivel de base de datos.
  - Cifrado local de los archivos de datos si se usan en dispositivos móviles.

### Criterio 6h) Tratamiento de datos y análisis:
- ¿Cómo se gestionan los datos en tu software y qué metodologías utilizas?

Actualmente, el software gestiona los datos mediante almacenamiento en archivos .json y .txt. Se siguen estructuras organizadas por entidad (robots, mantenimientos, técnicos), con una clara separación de responsabilidades y uso de listas indexadas para gestionar las entradas.

Los datos se serializan y deserializan con las herramientas nativas de Kotlin, lo que permite mantener consistencia y estructura sin requerir bases de datos externas.

En fases futuras, se implementará una base de datos SQLite para mejorar la integridad referencial, la escalabilidad del sistema y permitir funcionalidades avanzadas como búsquedas complejas, filtros por fechas o estadísticas de intervención. Esta transición será transparente para el usuario y está prevista en la hoja de ruta del proyecto.

- ¿Qué haces para garantizar la calidad y consistencia de los datos?

  - Restricciones de integridad en la base de datos.
  - Validaciones de entrada.
  - Estructuras simples para evitar redundancias.
  - Comentarios en el código que ayudan al mantenimiento y revisión.
