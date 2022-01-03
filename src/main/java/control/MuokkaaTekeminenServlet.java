package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.TekeminenJdbcDAO;
import database.TekeminenDAO;
import model.Tekeminen;

@WebServlet("/muokkaa_tekemiset") // endpoint kutsu www-osoitteessa

public class MuokkaaTekeminenServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String idString = request.getParameter("id");
		int tekeminenId = Integer.parseInt(idString);
		
		TekeminenDAO tekeminendao = new TekeminenJdbcDAO();
		Tekeminen tekeminen = null;
		tekeminen = tekeminendao.findById(tekeminenId);
		request.setAttribute("tekeminen", tekeminen);
		
		request.getRequestDispatcher("/WEB-INF/muokkaatekeminen.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String nimi = request.getParameter("nimi");
			String kuvaus = request.getParameter("kuvaus");
			String sijainti = request.getParameter("sijainti");
			
			Tekeminen tekeminen = new Tekeminen(id, nimi, kuvaus, sijainti);
			
			TekeminenDAO tekeminendao = new TekeminenJdbcDAO();
			boolean onnistunutMuokkaaminen = tekeminendao.editTekeminen(tekeminen);
			
			if (onnistunutMuokkaaminen)
				response.sendRedirect("/listaa_tekemiset");
			
			else {
				request.setAttribute("viesti", "Muokkaaminen epäonnistui");
				request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("viesti", "Muokkaaminen epäonnistui");
			request.getRequestDispatcher("/WEB-INF/virheilmoitus.jsp").forward(request, response);
		}
	}
	
}
