package Cursos;

import java.sql.*;

public class SQLiteJDBC {
	public static void main (String [ ] args) {
		conectar();

}
public static Connection conectar() {
	  Connection c = null;
	  Statement stmt = null;
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:/home/adrian/eclipse-workspace/Cursos2/WebContent/WEB-INF/lib/bbdd.db");
        
 	    stmt = c.createStatement();
 	    String sql = "CREATE TABLE IF NOT EXISTS USUARIO (NAME VARCHAR(100),EMAIL VARCHAR(100),PASSWORD VARCHAR(50)"
 	    		+ ");"; 
 	    stmt.executeUpdate(sql);
     	System.out.println("Conectado a la bbdd");
         return c;
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         
      }
      return null;
}
   

}