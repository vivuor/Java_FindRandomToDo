package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TekeminenDAO;
import database.TekeminenJdbcDAO;

@WebServlet ("/poista_tekeminen") // endpoint kutsu www-osoitteeseen

public class PoistaTekeminenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			TekeminenDAO tekeminendao = new TekeminenJdbcDAO();
			boolean onnistunutPoisto = tekeminendao.removeTekeminen(id);
			
			if (onnistunutPoisto) {
				response.sendRedirect("/listaa_tekemiset");
			} else {
				request.setAttribute("viesti", "Tekemisen poistamisessa tapahtui virhe!");
				request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
			request.setAttribute("viesti", "Sovelluksessa tapahtui virhe");
			request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
		} 
	}

}
