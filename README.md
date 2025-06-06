# 🛒 FoodExpress – Product Service

![Product Service](https://img.shields.io/badge/status-production-brightgreen)  
![Java](https://img.shields.io/badge/java-17-blue)  
![Spring Boot](https://img.shields.io/badge/spring--boot-3.4.6-green)  
![License](https://img.shields.io/badge/license-MIT-blue)

---

## 📝 Descripción

Microservicio encargado de:
- Crear, leer, actualizar y eliminar (`CRUD`) productos.
- Filtrar productos por stock y precio.
- Documentación automática de la API con OpenAPI/Swagger.

---

## 🚀 Características

- **RESTful Endpoints** para operaciones sobre productos.
- **Validaciones** con Jakarta Validation (`@NotNull`, `@Size`, etc.).
- **Persistencia** en Oracle (o H2 en memoria para pruebas).
- **Swagger UI** disponible en `/doc/swagger-ui.html`.
- **Spring Actuator** para métricas y salud.
- **Manejo de excepciones** centralizado (custom `ErrorPrinter`).

---

## 📐 Arquitectura

![Arquitectura](docs/architecture.png)  
> Diagramado con PlantUML en `docs/architecture.puml`.

---

## 🛠️ Instalación

1. **Clonar el repositorio**  
   ```bash
   git clone https://github.com/OrionTheProgramer/product-service.git
   cd product-service
