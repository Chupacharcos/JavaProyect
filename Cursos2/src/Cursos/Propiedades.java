package Cursos;

import java.io.IOException;
import java.util.Properties;

public class Propiedades {

      static public void main(String[] args){
          Properties prop = new Properties();

          try {
               prop.load( Propiedades.class.getClassLoader().getResourceAsStream("Cursos\\datos.properties") );

               System.out.println("Version:\t" + prop.getProperty("version") );
               System.out.println("Archivo base de datos:\t" + prop.getProperty("bbdd") );
          }catch(IOException ex)
          {
                System.err.println("Error al acceder al archivo de propiedades");
                ex.printStackTrace();

           }
      }
}