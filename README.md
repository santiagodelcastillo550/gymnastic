-----------------------------------
------      GYMNASTIC        ------
-----------------------------------

------ Descripción           ------

GYMNASTIC es una aplicación web completa diseñada para optimizar 
y facilitar la planificación de rutinas de ejercicios para usuarios de gimnasios, 
tanto principiantes como avanzados. La aplicación permite a los usuarios 
acceder a rutinas predefinidas,creadas por expertos, y apuntarlas como favoritas, 
mientras se va monitorizando el progreso. 
Con un enfoque en la facilidad de uso y la seguridad, 
GYMNASTIC proporciona una plataforma robusta y eficiente para mejorar la experiencia de entrenamiento.

------ Tecnologías Utilizadas ------

- **Java Spring**: Framework principal para la creación del backend y manejo de la lógica de negocio.
- **Spring Web**: Creación de controladores y gestión de solicitudes HTTP y sus respuestas.
- **H2 Database**: Base de datos en memoria utilizada para el almacenamiento de datos, en este caso en fichero.
- **Spring Security**: Proporciona autenticación y autorización para la aplicación.
- **Thymeleaf**: Motor de plantillas para generar contenido HTML dinámico.
- **Spring DevTools**: Herramientas para agilizar el desarrollo y mejorar la productividad.

------ Acceso a la aplicación ------

Para acceder a la aplicación, después de ejecutarla, tienes q poner este puerto en el navegador:

---> http://localhost:8090


------ Estructura del proyecto -----

El proyecto está estructurado en paquetes diversos:

- **com.example.gymnastic**: Paquete base que añade la clase de arranque de la aplicación.
- **com.example.gymnastic.bussiness**: Paquete encargado de tener los servicios con la lógica de negocio.
- **com.example.gymnastic.common.exception**: Paquete que tiene las excepciones.
- **com.example.gymnstic.controller**: Paquete encargado de tener los controladores y manejo entre templates.
- **com.example.gymnastic.entities**: Paquete que tiene las entidades del proyecto que luego serán las tablas del proyecto.
- **com.example.gymnastic.repositories**: Paquete que tiene los repositorios para interactuar con la base de datos.
- **com.example.gymnastic.security.config**: Paquete que tiene la seguridad del proyecto
- **src/main/resources/static**: Se encarga de guardar imágenes, index y estilos.
- **src/main/resources/templates/fragments**: Se encarga de tener código repetido en fragmentos en común. 
- **src/main/resources/templates**: Se encarga de tener código de las páginas que se muestran en la web.
- **application.properties**: Archivo de configuración principal de Spring Boot.
- **data.sql**: Archivo que tiene dentro datos iniciales que se cargan cuando se ejcuta la aplicación.
- **src/test/java**: Carpeta que contiene los paquetes de los tests.