package Cursos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Comentar
 */
@WebServlet("/Comentar")
public class Comentar extends HttpServlet {
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nick = request.getParameter("nick_comments");
        String comments = request.getParameter("comments");
      
       
        try {
			Connection c = SQLiteJDBC.conectar();
			Statement stmt = null;
			stmt = c.createStatement();
			String insert = "INSERT INTO COMENTARIOS (NAME,COMMENTS) VALUES ('"+nick+"','"+comments+"')";
			stmt.executeUpdate(insert);
			response.sendRedirect("/Cursos2/html/reservaCorrecta.html");
		} catch (Exception e) {
			response.sendRedirect("/Cursos2/html/reservaIncorrecta.html");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

		}
	}
	}



