# CONVERTIDOR DE NÚMEROS ARÁBIGOS A ROMANOS

El presente proyecto pertenece a una prueba técnica cuyo requisito principal es convertir números arábigos a romanos

## Pre requisitos 
* Maven 3.3.9
* Meteor 1.8.0.2
* Nodejs 10.11.0
* Java JDK 1.8

### Proyecto
El proyecto convertidor-numeros se compone de la siguiente manera:
```
convertidor-numeros-jar: Es el microservicio basado en SpringBoot el cual contiene la lógica de conversión.
convertidor-numeros-web: Es el front-end basado en Nodejs y Meteor, el cual interactua con el microservicio. 
```

## Configuración 
Para ejecutar el proyecto de SpringBoot, se debe ejecutar desde el folder convertidor-numeros-jar el comando siguiente:
 
```
mvn spring-boot:run
```

Comprobar con la url: http://localhost:8080/convertir/arabigo/romano/1

Para ejecutar el proyecto de Nodejs con Meteor, se debe ejecutar desde el folder convertidor-numeros-web los siguientes comandos:

```
npm install
meteor run
```

Comprobar con la url: http://localhost:3000/