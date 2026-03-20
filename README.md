# Backend Videoclub ejercicio en Vanilla 

Aplicación de escritorio en Java que permite gestionar películas de un videoclub mediante consola. Utiliza arquitectura **MVC** y se conecta a una base de datos **MySQL**.

---

## Tecnologías

| Tecnología | Versión |
|---|---|
| Java | 25 |
| Maven | 4.0.0 |
| MySQL Connector/J | 9.6.0 |
| MySQL | 8.0+ |

---

## Arquitectura MVC

El proyecto sigue el patrón **Model – View – Controller**:

```
src/main/java/org/factoria/
│
├── Main.java                      → Punto de entrada
├── config/
│   └── DBManager.java             → Gestión de la conexión a la base de datos
├── model/
│   └── Movie.java                 → Entidad / modelo de datos
├── repository/
│   ├── MovieRepository.java       → Interfaz del repositorio
│   └── MovieRepositoryImpl.java   → Implementación con SQL (JDBC)
├── controller/
│   └── MovieController.java       → Lógica de control entre View y Repository
└── view/
    └── MovieView.java             → Interacción con el usuario por consola
```

### Flujo de datos

```
Usuario → MovieView → MovieController → MovieRepositoryImpl → MySQL
```

---

## Base de datos

### Configuración de conexión

La conexión está definida en `DBManager.java`:

| Parámetro | Valor |
|---|---|
| Host | `localhost` |
| Puerto | `3306` |
| Base de datos | `videoclub_app` |
| Usuario | `root` |
| Contraseña | `root` |

### Crear la base de datos y la tabla

Antes de ejecutar la aplicación debes crear manualmente la base de datos y la tabla en MySQL:

```sql
CREATE DATABASE videoclub_app;

USE videoclub_app;

CREATE TABLE movies (
    id                INT AUTO_INCREMENT PRIMARY KEY,
    title             VARCHAR(255),
    year              INT,
    director          VARCHAR(255),
    main_cast         VARCHAR(255),
    filmaffinity_score DOUBLE,
    description       TEXT,
    img               VARCHAR(255),
    url               VARCHAR(255),
    ranking           DOUBLE
);
```

---

## Funcionalidades

### Crear película (`generateMovie`)
Solicita al usuario por consola los siguientes campos y los inserta en la base de datos:

- Título
- Año
- Director
- Reparto principal
- Puntuación FilmAffinity
- Descripción
- URL de la imagen
- URL de FilmAffinity
- Ranking

### Listar películas (`showMovies`)
Recupera todas las películas de la base de datos y las muestra por consola.

---

## Clases principales

### `Movie.java`
Entidad que representa una película. Campos:

| Campo | Tipo |
|---|---|
| `id` | `int` |
| `title` | `String` |
| `year` | `int` |
| `director` | `String` |
| `main_cast` | `String` |
| `filmAffinity_score` | `double` |
| `description` | `String` |
| `img` | `String` |
| `url` | `String` |
| `rank` | `double` |

### `MovieRepositoryImpl.java`
Accede a la base de datos usando **JDBC con PreparedStatement** (evita SQL injection).

- `createMovie(Movie)` → ejecuta un `INSERT`
- `findAll()` → ejecuta un `SELECT *` y devuelve `List<Movie>`

### `MovieController.java`
Actúa de intermediario entre la vista y el repositorio.

- `createMovieController(Movie)` → llama a `createMovie`
- `findAllController()` → llama a `findAll` y devuelve la lista

### `MovieView.java`
Gestiona la entrada/salida por consola usando `Scanner`.

- `generateMovie()` → recoge datos del usuario y los envía al controller
- `showMovies()` → pide la lista al controller y la imprime

### `DBManager.java`
Gestiona la conexión estática a MySQL.

- `InitConnection()` → abre y devuelve la conexión
- `closeConnection()` → cierra la conexión activa

---

## Cómo ejecutar

### 1. Clona el repositorio

```bash
git clone <url-del-repositorio>
cd backendVideoclub
```

### 2. Crea la base de datos

Ejecuta el SQL del apartado [Base de datos](#base-de-datos) en tu MySQL local.

### 3. Compila con Maven

```bash
mvn clean install
```

### 4. Ejecuta

```bash
mvn exec:java -Dexec.mainClass="org.factoria.Main"
```

O bien ejecuta directamente desde tu IDE (IntelliJ IDEA) la clase `Main.java`.

---

## Punto de entrada (`Main.java`)

```java
MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
MovieController movieController = new MovieController(movieRepository);
MovieView movieView = new MovieView(movieController);

movieView.generateMovie();  // Crear una película
movieView.showMovies();     // Listar todas las películas
```

---

## Notas

- Las credenciales de la base de datos están hardcodeadas en `DBManager.java`. En un entorno real deberían cargarse desde variables de entorno o un archivo de configuración.
- La interfaz `MovieRepository.java` existe como base para aplicar el principio de inversión de dependencias (SOLID), pero actualmente está vacía.
- El proyecto usa `PreparedStatement` para todas las consultas, lo que previene inyección SQL.