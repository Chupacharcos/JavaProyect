package Cursos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpRegCase {

	@Test
public void testNombre() {
		boolean resultado = Registro.comprobarNombre("adrian123");
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	
	@Test
public void testNombreFail() {
		boolean resultado = Registro.comprobarNombre("pi");
		boolean esperado = false;
		assertEquals(esperado,resultado);
	}
	
	@Test
public void testPass() {
		boolean resultado = Registro.comprobarPass("1234adrian");
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	@Test
public void testPassFail() {
		boolean resultado = Registro.comprobarPass("123");
		boolean esperado = false;
		assertEquals(esperado,resultado);
	}
	
	@Test
public void testEmail() {
		boolean resultado = Registro.comprobarEmail("adrian@gmail.com");
		boolean esperado = true;
		assertEquals(esperado,resultado);
	}
	@Test
	public void testEmailFail() {
		boolean resultado = Registro.comprobarEmail("adr1231277777//)(/·$31ian@@gmfasdfa123123ail.131312com");
		boolean esperado = false;
		assertEquals(esperado,resultado);
	}
}
