# Desafio Uno

Este proyecto expone un API REST que entrega la siguiente información:

*id*: identificador
*fechaCreacion*: Fecha de inicio de la secuencia
*fechaFin*: Fecha de fin de la secuencia
*fechas*: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
*fechasFaltantes*: Lista de fechas faltantes segun informacion recibida de API: "Generador Datos Desafio"
Ejemplo.

```json
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"],
    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"]
}
```
*Nota*:
El formato de las fechas es yyyy-MM-dd
El servicio entrega 1 periodo con la información de la API consumida donde el periodo contiene una fecha inicial una fecha final, una lista fechas y una lista de fechas faltantes.

# Detalle de los sistemas

Java 8
Spring-Boot 2.1.18.RELEASE
Maven 3


# Compilar y ejecutar el proyecto
Como requisito se compilar y ejecutar el proyecto: "Generador Datos Desafio", para ello seguir las intrucciones indicadas
en el Readme del proyecto ubicado en

https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno


Para copilar el proyecto se requiere Java y Maven instalado.
Ingresar al directorio *ApiPeriodos* ejecutar el siguiente comando *maven*

```bash
mvn package
```



Luego de compilar el proyecto ingresar al directorio *target* ejecutar el siguiente comando *java*

```bash
java -jar .\api-desafiouno-1.0.0.jar
```
*Nota*:
Debe estar disponible el puerto *8081* en el PC donde se ejecute esta API

# Consumir la API

Para consumir el servicio se debe invocar la siguiente URL

```bash
curl -X GET 'http://127.0.0.1:8081/desafiouno/obtener'
```
