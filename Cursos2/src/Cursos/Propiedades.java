package Cursos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propiedades {
	String result = "";
	InputStream inputStream;
	/**
	 * 
	 * @return query creaccion table cursos
	 * @throws IOException
	 */
      public String createTableCursos() throws IOException {
    	    		try {
  			Properties prop = new Properties();
  			String propFileName = "\\Cursos\\datos.properties";
   
  			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
   
  			if (inputStream != null) {
  				prop.load(inputStream);
  			} else {
  				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
  			}
   
  			
   
  			// get the property value and print it out
  			result = prop.getProperty("create_cursos");
  			
   
  			
  		
  		} catch (Exception e) {
  			System.out.println("Exception: " + e);
  		} finally {
  			inputStream.close();
  		}
  		return result;
  	}
      /**
       * 
       * @return nombre archivo base de datos
       * @throws IOException
       */
      public String getDatabaseName() throws IOException {
    		try {
      			Properties prop = new Properties();
      			String propFileName = "\\Cursos\\datos.properties";
       
      			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
       
      			if (inputStream != null) {
      				prop.load(inputStream);
      			} else {
      				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
      			}
       
      			
       
      			// get the property value and print it out
      			result = prop.getProperty("bbdd");
      			
       
      			
      		
      		} catch (Exception e) {
      			System.out.println("Exception: " + e);
      		} finally {
      			inputStream.close();
      		}
      		return result;
      	}
      
}