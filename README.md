# spring-back-state-mgmt

## Lenguajes y herramientas:

Este proyecto utiliza:

. Java 17 SDK (se recomienda su gestión con SDKMan)
. Spring-Boot Framework

## Como construir

Para construir el proyecto ejecuté:

```bash
./mvnw clean package -X
````

Para correr el proyecto ejecuté:
```bash
./mvnw spring-boot:run
```

# API

Esta API proporciona endpoints para administrar datos geográficos como países, estados y ciudades. Utiliza listas en memoria para almacenar los datos, sin requerir una base de datos.

## Endpoints de Ciudades

### Obtener todas las ciudades

`GET /api/v1/city`

Retorna todas las ciudades almacenadas.

### Obtener una ciudad por su ID

`GET /api/v1/city/{id}`

Retorna los detalles de una ciudad específica basada en su ID.

### Crear una nueva ciudad

`POST /api/v1/city`

Crea una nueva ciudad con los detalles proporcionados en el cuerpo de la solicitud.

```json
{
  "name": "Nueva Ciudad",
  "stateId": 1
}
```

### Actualizar una ciudad existente

`PUT /api/v1/city/{id}`

Actualiza los detalles de una ciudad existente basada en su ID, utilizando los datos proporcionados en el cuerpo de la solicitud.

```json
{
"name": "Ciudad Actualizada",
"stateId": 2
}
```

## Endpoints de Países

### Obtener todos los países

`GET /api/v1/country`

Retorna todos los países almacenados.

### Obtener un país por su ID

`GET /api/v1/country/{id}`

Retorna los detalles de un país específico basado en su ID.

### Crear un nuevo país

`POST /api/v1/country`

Crea un nuevo país con los detalles proporcionados en el cuerpo de la solicitud.

```json
{
  "name": "Nuevo País"
}
```

### Actualizar un país existente

`PUT /api/v1/country/{id}`

Actualiza los detalles de un país existente basado en su ID, utilizando los datos proporcionados en el cuerpo de la solicitud.

```json
{
  "name": "País Actualizado"
}
```

## Endpoints de Estados

### Obtener todos los estados

`GET /api/v1/state`

Retorna todos los estados almacenados.

### Obtener un estado por su ID

`GET /api/v1/state/{id}`

Retorna los detalles de un estado específico basado en su ID.

### Crear un nuevo estado

`POST /api/v1/state`

Crea un nuevo estado con los detalles proporcionados en el cuerpo de la solicitud.

```json
{
  "name": "Nuevo Estado",
  "countryId": 1
}
```

### Actualizar un estado existente

`PUT /api/v1/state/{id}`

Actualiza los detalles de un estado existente basado en su ID, utilizando los datos proporcionados en el cuerpo de la solicitud.

```json
{
  "name": "Estado Actualizado",
  "countryId": 2
}
```

## Endpoint para los paises seleccionados.

### Agregar un pais a la lista de paises seleccionados

`POST http://localhost:8080/api/v1/table`

Agrega un pais a la lista de paises seleccionados con los detalles proporcionados en el cuerpo de la solicitud.

```json
[
  {
    "id": 1,
    "country": {
      "id": 1,
      "name": "Spain"
    },
    "state": {
      "id": 1,
      "name": "Madrid",
      "countryId": 1
    },
    "city": {
      "id": 1,
      "name": "Madrid",
      "stateId": 1
    }
  }
]
```

## Ejecución

1. Clona el repositorio.

2. Ejecuta la aplicación.

3. Utiliza tu cliente HTTP favorito (por ejemplo, Postman) para realizar las solicitudes a los diferentes endpoints. Los archivos con las solicitudes correspondientes se encuentran en la carpeta `/http`.
# Proyecto_Practico
# Proyecto_Practico
# Proyecto_Practico
# Proyecto_Practico
