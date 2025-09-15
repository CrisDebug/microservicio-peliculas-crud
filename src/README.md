# Proyecto CRUD de Películas con Spring Boot y Oracle XE

Este proyecto es una aplicación backend RESTful desarrollada con **Spring Boot** que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una base de datos Oracle XE 21c.

---

## Tecnologías usadas

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Oracle XE 21c
- SQL Developer (para manipulación de base de datos)
- Postman (para pruebas de API)
- Docker (opcional para despliegue de base de datos o app)

---

## Configuración de la base de datos
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:XE
spring.datasource.username=system
spring.datasource.password=Online.123
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect

server.port=9090

##docker
version: '3.8'

services:
  oracle-xe:
    image: oracleinanutshell/oracle-xe-11g
    container_name: oracle-xe
    ports:
      - "1521:1521"
      - "8080:8080"
    environment:
      - ORACLE_ALLOW_REMOTE=true
      - ORACLE_PASSWORD=Online.123
    restart: unless-stopped

### Tabla `peliculas`

```sql
CREATE TABLE peliculas (
  id_pelicula NUMBER PRIMARY KEY,
  titulo VARCHAR2(255) NOT NULL,
  anio NUMBER(4),
  director VARCHAR2(255),
  genero VARCHAR2(100),
  sinopsis CLOB
);
