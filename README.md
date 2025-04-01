# Parcial1B
Proyecto GESTION-PRODUCTOS-REACTIVO
Descripción
Este proyecto es una API RESTful desarrollada con Spring Boot para la gestión de productos, utilizando MongoDB como base de datos y WebFlux para un enfoque reactivo. Permite crear, listar, obtener y eliminar productos, además de incluir autenticación y seguridad con JWT.
Tecnologías Usadas
•	Java 17
•	Spring Boot 3.4.5
•	Spring WebFlux
•	Spring Data MongoDB
•	Spring Security
•	JWT (Json Web Token)
•	Lombok
•	Maven
Características
•	API Reactiva: Uso de WebFlux para manejar solicitudes HTTP de manera no bloqueante.
•	Seguridad: Autenticación basada en JWT para asegurar los endpoints de la API.
•	CRUD de Productos: Crear, leer, actualizar y eliminar productos.
•	MongoDB: Base de datos NoSQL para almacenar los productos.
•	Pruebas Unitarias: Con Mockito para simular dependencias y JUnit para validaciones.
•	Pruebas de Integración: Usando WebTestClient para probar los endpoints de la API.
Endpoints Disponibles
1. Crear un Producto
•	Método: POST
•	Ruta: /api/productos
•	Cuerpo:
json
CopiarEditar
{
  "nombre": "Producto Ejemplo",
  "descripcion": "Descripción del producto",
  "precio": 100.0
}
•	Respuesta:
json
CopiarEditar
{
  "id": "123456789",
  "nombre": "Producto Ejemplo",
  "descripcion": "Descripción del producto",
  "precio": 100.0
}
2. Obtener Producto por ID
•	Método: GET
•	Ruta: /api/productos/{id}
•	Respuesta:
json
CopiarEditar
{
  "id": "123456789",
  "nombre": "Producto Ejemplo",
  "descripcion": "Descripción del producto",
  "precio": 100.0
}
3. Eliminar Producto
•	Método: DELETE
•	Ruta: /api/productos/{id}
•	Respuesta:
json
CopiarEditar
{
  "mensaje": "Producto eliminado correctamente"
}
Cómo Ejecutar el Proyecto
Requisitos Previos
•	JDK 17
•	Maven (para gestionar dependencias)
•	MongoDB (o una base de datos compatible con MongoDB)
Pasos para ejecutar el proyecto
1.	Clona el repositorio:
bash
CopiarEditar
git clone https://github.com/tuusuario/miempresa.git
2.	Ingresa al directorio del proyecto:
bash
CopiarEditar
cd miempresa
3.	Instala las dependencias:
bash
CopiarEditar
mvn clean install
4.	Ejecuta la aplicación:
bash
CopiarEditar
mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.
Pruebas
Pruebas Unitarias
Se usan pruebas unitarias con JUnit y Mockito para simular las dependencias y validar el comportamiento del servicio de productos.
Pruebas de Integración
Se utilizan pruebas de integración con WebTestClient para simular peticiones HTTP y verificar la funcionalidad de la API en un entorno real.
CI/CD con GitHub Actions
Este proyecto está configurado con un pipeline de CI/CD utilizando GitHub Actions para ejecutar pruebas automáticas en cada push o pull request a la rama main.
El archivo de configuración del workflow está en .github/workflows/test.yml.
Contribución
¡Contribuir es bienvenido! Si tienes alguna sugerencia o mejoras, abre un Issue o envía un Pull Request.

