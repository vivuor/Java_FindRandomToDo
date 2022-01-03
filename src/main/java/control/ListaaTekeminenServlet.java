package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TekeminenDAO;
import database.TekeminenJdbcDAO;
import model.Tekeminen;

@WebServlet ("/listaa_tekemiset") // endpoint kutsu www-osoitteessa

public class ListaaTekeminenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TekeminenDAO tekeminendao = new TekeminenJdbcDAO();
		List<Tekeminen> tekemiset = tekeminendao.findAll();
		
		request.setAttribute("tekemiset", tekemiset); // "tekemiset" on keyword arvo. Voi olla mikä tahansa, mutta se JSP käyttää sitä.
		
		request.getRequestDispatcher("/WEB-INF/tekemisetlista.jsp").forward(request, response);
	}

}
