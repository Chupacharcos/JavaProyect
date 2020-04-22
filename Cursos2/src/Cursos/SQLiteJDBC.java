package Cursos;

import java.sql.*;

public class SQLiteJDBC {
	public static void main (String [ ] args) {
		conectar();

}
	/**
	 * 
	 * @return conexion a la base de datos
	 */
public static Connection conectar() {
	  Connection c = null;
	  Statement stmt = null;
      try {
    	  String bbdd_name = new Propiedades().getDatabaseName();
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Adrian\\git\\m8\\Cursos2\\WebContent\\WEB-INF\\lib\\"+bbdd_name);
        
 	    stmt = c.createStatement();
 	    String sql = "CREATE TABLE IF NOT EXISTS USUARIO (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(100),EMAIL VARCHAR(100),PASSWORD VARCHAR(50)"
 	    		+ ");"; 
 	    stmt.executeUpdate(sql);
 	   System.out.println("Creada tabla usuarios");
 	   String sql_cursos = new Propiedades().createTableCursos();
 	  
 	    /*
 			   String sql_cursos = "CREATE TABLE IF NOT EXISTS CURSOS (\n" + 
 	    		"REF INTEGER PRIMARY KEY AUTOINCREMENT,\n" + 
 	    		"NAME VARCHAR(100),\n" + 
 	    		"PRODUCTS VARCHAR(100),\n" + 
 	    		"PAYMENT VARCHAR(100),\n" + 
 	    		"GRADE INTEGER(1),\n" + 
 	    		"AMOUNT INTEGER(10) DEFAULT 0,\n" + 
 	    		"CONSTRAINT FK_NAME FOREIGN KEY (NAME) REFERENCES USUARIO(NAME)\n" + 
 	    		");";
 	    */
 	   stmt.executeUpdate(sql_cursos);
 	  System.out.println("Creada tabla cursos");
 	  String sql_comments = "CREATE TABLE IF NOT EXISTS COMENTARIOS (\n" + 
 	  		"REF INTEGER PRIMARY KEY AUTOINCREMENT,\n" + 
 	  		"NAME VARCHAR(100),\n" + 
 	  		"COMMENTS VARCHAR(500),\n" + 
 	  		"CONSTRAINT FK_NAME_COMMENTS FOREIGN KEY (NAME) REFERENCES USUARIO(NAME)\n" + 
 	  		");";
	   stmt.executeUpdate(sql_comments);
	  System.out.println("Creada tabla comentarios");
     	System.out.println("Conectado a la bbdd");
         return c;
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         
      }
      return null;
}
   

}