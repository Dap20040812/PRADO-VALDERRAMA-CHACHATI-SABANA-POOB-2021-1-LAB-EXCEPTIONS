 # Laboratorio Excepciones

 ## Parte 1

 - ¿Cómo se lanza una excepción en JAVA?

  throw new Exception

 - ¿Cómo se propaga una excepción en JAVA?

   public void Algo() throws Exception

 - ¿Cómo se captura una excepción en JAVA?

   try
   {
     Algo()
   }
   catch(Exception e)
   {

   }

 - ¿Cuál es la diferencia en la implementación de las pruebas? ¿Validan lo mismo?

 No porque ya no validad que el metodo regrese un boolean, sino que ahora verifican que retornen una excepción en especifico 
