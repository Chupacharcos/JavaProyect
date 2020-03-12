package Cursos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String payment = request.getParameter("payment");
        String nick = request.getParameter("nick");
        String grade = request.getParameter("grade");
        String products = "";
        Integer amount = 0;
        if(request.getParameter("Curso1") != null && !request.getParameter("Curso1").isEmpty()) {
        	products += "Curso1";
        	amount += 10;
        }
        if(request.getParameter("Curso2") != null && !request.getParameter("Curso2").isEmpty()) {
        	products += "Curso2";
        	amount += 10;
        }
        if(request.getParameter("Curso3") != null && !request.getParameter("Curso3").isEmpty()) {
        	products += "Curso3";
        	amount += 10;
        }
        if(request.getParameter("Curso4") != null && !request.getParameter("Curso4").isEmpty()) {
        	products += "Curso4";
        	amount += 10;
        }
        if(request.getParameter("Curso5") != null && !request.getParameter("Curso5").isEmpty()) {
        	products += "Curso5";
        	amount += 10;
        }
        try {
			Connection c = SQLiteJDBC.conectar();
			Statement stmt = null;
			stmt = c.createStatement();
			String insert = "INSERT INTO CURSOS (NAME,PRODUCTS,PAYMENT,GRADE,AMOUNT) VALUES ('"+nick+"','"+products+"','"+payment+"',"+grade+","+amount+")";
			stmt.executeUpdate(insert);
			response.sendRedirect("/Cursos2/html/reservaCorrecta.html");
		} catch (Exception e) {
			response.sendRedirect("/Cursos2/html/reservaIncorrecta.html");
			System.err.println(e.getClass().getName() + ": " + e.getMessage());

		}
	}

}
