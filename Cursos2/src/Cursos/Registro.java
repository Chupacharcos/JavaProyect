package Cursos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registro
 */

@WebServlet("/Registro")
public class Registro extends HttpServlet {
	public static boolean comprobarNombre(String name) {
		if (name.matches("[a-zA-Z0-9]{3,10}")) {
			return true;
		}else{
			return false;
		}
	}
	public static boolean comprobarPass(String password) {
		if (password.matches("[a-zA-Z0-9]{8,}")) {
			return true;
		}else{
			return false;
		}
	}
	public static boolean comprobarEmail(String email) {
		if (email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$")) {
			return true;
		}else{
			return false;
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read form fields
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
//METER LOS MATCHES EN FUNCIONES PARA LOS TEST
		
		if (comprobarNombre(name) && comprobarPass(password)
				&& comprobarEmail(email)) {
			try {
				Connection c = SQLiteJDBC.conectar();
				Statement stmt = null;
				stmt = c.createStatement();
				String sql_exists = "SELECT COUNT(*) AS 'contador' FROM USUARIO WHERE NICK = '" + name + "'";
				ResultSet r = stmt.executeQuery(sql_exists);
				r.next();
				int count = r.getInt("contador") ;
				if (count>0) {
					response.sendRedirect("/Cursos2/html/registroIncorrecto.html");
				} else {
					stmt = c.createStatement();
					String sql = "INSERT INTO USUARIO (NICK,PASS,EMAIL) VALUES ('" + name + "','" + password + "','"
							+ email + "')";
					stmt.executeUpdate(sql);
					response.sendRedirect("/Cursos2/html/registroCorrecto.html");
				}

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());

			}
		} else {
		
			response.sendRedirect("/Cursos2/html/registroIncorrecto.html");
		}
		/*
		 * if (name.matches("[a-zA-Z0-9]{3,10}") && password.matches("[a-zA-Z0-9]{8,}")
		 * && email.matches("[^@]+@[^\\.]+\\..+")) {
		 * System.out.println("ENTRA EN EL IF DE LOS MATCHES");
		 * 
		 * try { Connection c = SQLiteJDBC.conectar(); Statement stmt = null; stmt =
		 * c.createStatement(); String sql =
		 * "INSERT INTO USUARIO (NICK,PASS,EMAIL) VALUES ('"+name+"','"+password+"','"+
		 * email+"')"; stmt.executeUpdate(sql);
		 * 
		 * response.sendRedirect("/Cursos2/html/registroCorrecto.html"); } catch (
		 * Exception e ) { System.err.println( e.getClass().getName() + ": " +
		 * e.getMessage() );
		 * response.sendRedirect("/Cursos2/html/registroIncorrecto.html"); }
		 * response.sendRedirect("/Cursos2/html/registroCorrecto.html"); }else {
		 * System.out.println("se va al else por no pasar los mathces");
		 * response.sendRedirect("/Cursos2/html/registroIncorrecto.html"); }
		 */
	}

}
