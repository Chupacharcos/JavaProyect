package Cursos;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class bdConnection {

	@Test
	public void comprobarConexion() throws SQLException {
		 Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Adrian\\git\\m8\\Cursos2\\WebContent\\WEB-INF\\lib\\bbdd.db");
	        assertTrue(conn.isValid(0));
	        conn.close();
	        assertFalse(conn.isValid(0));
	}

}
