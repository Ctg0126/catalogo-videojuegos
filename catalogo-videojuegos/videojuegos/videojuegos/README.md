# Catálogo de Videojuegos

Proyecto backend desarrollado con **Spring Boot** y **Maven**.

## Requisitos previos

- Java 11 o superior instalado (`java -version` para verificar)
- Maven instalado (`mvn -version` para verificar) — o usar el wrapper incluido (`./mvnw` / `mvnw.cmd`)
- Git instalado

## Clonar el repositorio

```bash
git clone https://github.com/Ctg0126/catalogo-videojuegos.git
cd catalogo-videojuegos
```

> Nota: el proyecto Spring Boot está dentro de la subcarpeta `catalogo-videojuegos/`, así que después de clonar entra también ahí:
> ```bash
> cd catalogo-videojuegos
> ```

## Instalar dependencias

```bash
mvn clean install
```

## Ejecutar el proyecto

Con Maven:

```bash
mvn spring-boot:run
```

O usando el wrapper (no requiere tener Maven instalado globalmente):

```bash
./mvnw spring-boot:run
```

En Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

Abre: 

```
http://localhost:8081/videojuegos
```

(revisa `server.port` en `application.properties` por si el puerto fue cambiado).

## Compilar el .jar ejecutable

```bash
mvn clean package
java -jar target/*.jar
```
