# Sony Service

El servicio de Sony es un WS SOAP que expone dos funcionalidades una para la cotización de una orden y sus respectivos items y la otra para validar una orden almacenada. Como no fue posible validar la lógica del servicio con el docente de pica, ya que no se recibio retroalimentación de las inquietudes expuestas con este servicio, se exponen las funcionalidades básicas que estaban en el contrato WSDL original.

## Archivos
- Código fuente servicio sony realizado con Spring Boot
- Script de BD
- Documentación
- Wsdl's
##  Requerimientos
- Base de datos Oracle XE (Se puede implementar en cualquier motor de base de datos, pero se debe realizar la configuración manualmente en el código fuente)
- Java JRE/JDK 8 (Tener configurada la variable [JAVA_HOME](https://javatutorial.net/set-java-home-windows-10) 

## Servicio

  El Web Service de Sony se compone de dos WSDL:

- http://localhost:8089/ws/cotizaciones.wsdl
Expone la operación SonyQuoteServiceProcess, el cual, recibe un objeto orden que contiene a su vez ítems y retorna el costo total de esa orden. 
  -  Parámetros de entrada:
     -  orderID: Numero de la orden a cotizar
     -  Items: Objeto que se compone de un identificador de Item y una cantidad
    -  Parámetros de salida: 
       -  SupplierPrice: Precio de los ítems cotizados.


- http://localhost:8089/ws/validaciones.wsdl
Expone la operación  OrderQuouteElement, recibe un numero de orden y retorna un booleano validando si la orden fue o no aprobada
  - Parámetros de entrada:
    - orderID: Numero de la orden a validar
  - Parámetros de salida: 
    - result: Booleano, es true si la orden esta aprobada, es false si la orden no fue aprobada.


## Instalación
Para la generación del archivo jar a partir del código fuente (Posterior a la validación de la conexión con la base de datos, para mayor información consultar el manual técnico incluido en el repositorio) se debe tener instalado maven, para mayor facilidad se puede realizar el proceso de compilado y empaquetado desde un IDE de java como eclipse.
Si se una una intalación local de maven se debe ubicar en la carpeta sony-service y empaquetar el proyecto.

    mvn package
Se generará una carpeta llamada targer, debe ingresar y verificar que se halla generado el archivo .jar, dentro de esta carpeta se debe ejecutar:

    java - jar sony-service-0.0.1-SNAPSHOT.jar

Si todo esta configurado correctamente la aplicación debe funcionar sin inconveniente

## Soporte

Cualquier inquietud por favor direccionarla al correo: skynetaes2019@gmail.com
- Tiempo de Respuesta 3 días calendario  

## Consideraciones adicionales
No se entrega un esquema de base de datos especifico ya que como se menciono anteriormente, la lógica del servicio no fue aclarada y adicionalmente uno de los requerimientos de la empresa kallsonys es que la BD de sony fuera alojada en la BD del sistema de información. 
