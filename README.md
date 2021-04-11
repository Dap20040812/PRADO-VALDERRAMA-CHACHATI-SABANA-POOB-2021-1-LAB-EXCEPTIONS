# LAB-EXCEPTIONS

## Dependencias

* Laboratorio de clases abstractas.
* Laboratorio de herencia.
* Laboratorio de interfaces.

## Parte I - Entendiendo las Excepciones

Actualmente tenemos un problema en nuestro caso de estudio de las figuras geométricas, es posible crear figuras con medidas negativas o iguales a cero, lo cual no debería ser posible. Fíjese en la implementación del constructor de la clase `Circle`, en el hacemos una validación para evitar la creación de círculos con radios negativos o iguales a 0.

```java
    public Circle(double radius) throws ShapeException {

        if (radius <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.radius = radius;
    }
``` 

Ahora revise estas pruebas que validan ese comportamiento.

```java
    @Test
    public void shouldNorCreateCircleWithRadiusNegative() {

        try {
            new Circle(-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNorCreateCircleWithRadiusZero() {

        Exception e = assertThrows(ShapeException.class, () -> new Circle(0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }
```

Responda las siguientes preguntas:

* ¿Cómo se lanza una excepción en JAVA?
* ¿Cómo se propaga una excepción en JAVA?
* ¿Cómo se captura una excepción en JAVA?
* ¿Cuál es la diferencia en la implementación de las pruebas? ¿Validan lo mismo?

## Parte II - Implementando Excepciones

* Asegúrese de expandir el comportamiento a lo largo de todas las clases del laboratorio anterior, `Circle`, `Rectangle`, `Triangle`, `Cylinder`, `RectangleSolid`, `Pyramid` y `Cube`.
* Cree las pruebas necesarias para validar este comportamiento.

## Parte III - Implementando Excepciones en un contexto

Revise de nuevo las pruebas `ColsubsidioFundTest`, algunas de ellas cambiaron y ahora esperan que se lance una excepción de tipo `FamilyCompensationFundException`.
Integre el código del laboratorio anterior:

* Modifique los métodos que sean necesarios para que dicha clase de pruebas funcione, no olvide propagar la excepción cuando corresponda.
* Haga que el mismo comportamiento suceda para las clases `CompensarFund` y `CafamFund`.

## Parte IV - Excepciones Integrando

Como ya habrá notado, al momento de cambiar el comportamiento de la interfaz de `IFamilyCompensationFund` para que lance excepciones, el compilador arrojará excepciones en distintos lugares, como en la clase `SabanaPayroll`.

* ¿Por qué el compilador muestra estos errores?.
* ¿Qué debemos hacer para controlarlos?.
* ¿Deben ser las excepciones en `SabanaPayroll` controladas o propagadas?.
* NO modifique las pruebas de `SabanaPayrollTest`, pero haga todos los cambios que sean necesarios en la clase `SabanaPayroll` para que las pruebas pasen.

 ## Parte V
 
 * Cree una nueva excepción personalizada para alguna de las funcionalidades anteriores que hemos implementado e integrela, no olvide modificar las pruebas.
 * En el archivo SOLUTION.md comente cuál fue su implementación.
 
 ## Condiciones
 
 * Todos los editables de los diagramas de este laboratorio se encuentran en la carpeta `diagrams`.
 * Cree un repositorio llamado APELLIDO1-APELLIDO2-APELLIDO3-SABANA-POOB-2021-1-LAB-ABSTRACT-CLASS en GitHub y suba allí la solución del laboratorio.
 * Cree un archivo SOLUTION.md donde deberá documentar toda la solución del laboratorio. NO MODIFIQUE EL README.md.
