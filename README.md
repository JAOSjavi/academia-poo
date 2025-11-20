# Academia POO

Sistema de gestión de academia desarrollado con Spring Boot que permite administrar estudiantes, profesores y clases. Este proyecto implementa una arquitectura en capas siguiendo principios de Programación Orientada a Objetos (POO) y Domain-Driven Design (DDD).

## 📋 Descripción

Academia POO es una aplicación REST API que facilita la gestión de una academia educativa, permitiendo:

- **Gestión de Estudiantes**: Crear, leer, actualizar y eliminar estudiantes
- **Gestión de Profesores**: Administrar información de profesores
- **Gestión de Clases**: Gestionar clases y sus relaciones con profesores y estudiantes

### Relaciones del Modelo de Datos

- Un **Profesor** puede impartir múltiples **Clases** (relación One-to-Many)
- Una **Clase** puede tener múltiples **Estudiantes** (relación Many-to-Many)
- Un **Estudiante** puede estar inscrito en múltiples **Clases** (relación Many-to-Many)

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Data JPA** - Para la persistencia de datos
- **MySQL** - Base de datos relacional
- **MapStruct 1.5.5** - Para mapeo entre entidades y DTOs
- **Maven** - Gestión de dependencias
- **Jakarta Persistence** - API de persistencia

## 📁 Estructura del Proyecto

```
academia-poo/
├── src/
│   ├── main/
│   │   ├── java/academia/academia_poo/
│   │   │   ├── AcademiaPooApplication.java
│   │   │   ├── controller/          # Controladores REST
│   │   │   │   ├── ClaseController.java
│   │   │   │   ├── EstudianteController.java
│   │   │   │   └── ProfesorController.java
│   │   │   ├── domain/              # Capa de dominio
│   │   │   │   ├── dto/             # Data Transfer Objects
│   │   │   │   ├── irepository/     # Interfaces de repositorio
│   │   │   │   └── service/         # Servicios de negocio
│   │   │   └── infraestructure/     # Capa de infraestructura
│   │   │       ├── crud/            # Repositorios JPA
│   │   │       ├── mapper/          # Mappers MapStruct
│   │   │       ├── model/           # Entidades JPA
│   │   │       └── repositories/    # Implementaciones de repositorios
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application.yaml
│   └── test/                        # Pruebas unitarias
└── pom.xml
```

## 🚀 Requisitos Previos

- **Java 17** o superior
- **Maven 3.6+**
- **MySQL 8.0+** o superior
- Un IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code, etc.)

## ⚙️ Configuración

### 1. Clonar el repositorio

```bash
git clone <url-del-repositorio>
cd academia-poo/academia-poo
```

### 2. Configurar la base de datos

Crea una base de datos MySQL:

```sql
CREATE DATABASE academia;
```

### 3. Configurar variables de entorno

Puedes configurar la conexión a la base de datos mediante variables de entorno o editar el archivo `src/main/resources/application.properties`.

**Variables de entorno disponibles:**
- `MYSQL_HOST` o `DB_HOST` (por defecto: `localhost`)
- `MYSQL_PORT` o `DB_PORT` (por defecto: `3306`)
- `MYSQL_DB` o `DB_NAME` (por defecto: `academia`)
- `MYSQL_USER` o `DB_USERNAME` (por defecto: `root`)
- `MYSQL_PASSWORD` o `DB_PASSWORD` (por defecto: vacío)

**Ejemplo de configuración en `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/academia?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

### 4. Compilar el proyecto

```bash
mvn clean install
```

## 🏃 Ejecución

### Ejecutar con Maven

```bash
mvn spring-boot:run
```

### Ejecutar el JAR compilado

```bash
java -jar target/academia-poo-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: `http://localhost:8080`

## 📡 Endpoints de la API

### Estudiantes

- `GET /api/estudiantes` - Obtener todos los estudiantes
- `GET /api/estudiantes/{id}` - Obtener un estudiante por ID
- `POST /api/estudiantes` - Crear un nuevo estudiante
- `PUT /api/estudiantes/{id}` - Actualizar un estudiante
- `DELETE /api/estudiantes/{id}` - Eliminar un estudiante

### Profesores

- `GET /api/profesores` - Obtener todos los profesores
- `GET /api/profesores/{id}` - Obtener un profesor por ID
- `POST /api/profesores` - Crear un nuevo profesor
- `PUT /api/profesores/{id}` - Actualizar un profesor
- `DELETE /api/profesores/{id}` - Eliminar un profesor

### Clases

- `GET /api/clases` - Obtener todas las clases
- `GET /api/clases/{id}` - Obtener una clase por ID
- `POST /api/clases` - Crear una nueva clase
- `PUT /api/clases/{id}` - Actualizar una clase
- `DELETE /api/clases/{id}` - Eliminar una clase

## 📝 Ejemplos de Uso

### Crear un Estudiante

```bash
curl -X POST http://localhost:8080/api/estudiantes \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "email": "juan.perez@example.com"
  }'
```

### Crear un Profesor

```bash
curl -X POST http://localhost:8080/api/profesores \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "María García",
    "email": "maria.garcia@example.com"
  }'
```

### Crear una Clase

```bash
curl -X POST http://localhost:8080/api/clases \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Programación Java",
    "descripcion": "Curso de programación orientada a objetos con Java",
    "profesorId": 1
  }'
```

## 🏗️ Arquitectura

El proyecto sigue una arquitectura en capas:

1. **Capa de Controladores**: Maneja las peticiones HTTP y respuestas REST
2. **Capa de Servicios**: Contiene la lógica de negocio
3. **Capa de Dominio**: Define las interfaces de repositorio y DTOs
4. **Capa de Infraestructura**: Implementa la persistencia (JPA) y mappers (MapStruct)

### Principios Aplicados

- **Separación de Responsabilidades**: Cada capa tiene una responsabilidad específica
- **Inversión de Dependencias**: Las capas superiores dependen de abstracciones (interfaces)
- **DTO Pattern**: Uso de DTOs para transferir datos entre capas
- **Repository Pattern**: Abstracción del acceso a datos

## 🧪 Pruebas

Ejecutar las pruebas unitarias:

```bash
mvn test
```

## 📦 Construcción

Para generar el JAR ejecutable:

```bash
mvn clean package
```

El archivo JAR se generará en `target/academia-poo-0.0.1-SNAPSHOT.jar`

## 🔧 Configuración de Base de Datos

La aplicación utiliza Hibernate con la estrategia `update` para el DDL, lo que significa que las tablas se crearán/actualizarán automáticamente al iniciar la aplicación.

Para ver las consultas SQL ejecutadas, la propiedad `spring.jpa.show-sql=true` está habilitada en el archivo de configuración.

## 📄 Licencia

Este proyecto es de uso educativo.

## 👥 Autor

Desarrollado como proyecto académico para demostrar conceptos de Programación Orientada a Objetos y arquitectura de software.

---

**Nota**: Asegúrate de tener MySQL ejecutándose antes de iniciar la aplicación.

