package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TekeminenJdbcDAO;
import database.TekeminenDAO;
import model.Tekeminen;

@WebServlet("/etusivu") // endpoint kutsu www-osoitteessa

public class LisaaUusiTekeminenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/etusivu.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String nimi = request.getParameter("nimi"); // tekemisen nimi
			String kuvaus = request.getParameter("kuvaus"); // tekemisen kuvaus
			String sijainti = request.getParameter("sijainti"); // tekemisen sijainti
			
			Tekeminen tekeminen = new Tekeminen(0, nimi, kuvaus, sijainti);
			
			TekeminenDAO tekeminendao = new TekeminenJdbcDAO();
			boolean onnistunutLisays = tekeminendao.addTekeminen(tekeminen);
			
			if (onnistunutLisays)
				response.sendRedirect("/etusivu");
			
			else {
				request.setAttribute("viesti", "Tekemisen lisäyksessä tapahtui virhe");
				request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("viesti", "Tekemisen tiedot eivät ole kelvolliset");
			request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
		}
		
	}

}
