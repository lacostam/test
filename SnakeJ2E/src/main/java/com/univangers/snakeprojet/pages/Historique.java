package com.univangers.snakeprojet.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.univangers.snakeprojet.dao.DaoFactory;
import com.univangers.snakeprojet.dao.PartieDao;
import com.univangers.snakeprojet.entity.Partie;
import com.univangers.snakeprojet.entity.User;

/**
 * Servlet implementation class Historique
 */
@WebServlet("/Historique")
public class Historique extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PartieDao partieDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historique() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.partieDao = daoFactory.getPartieDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = ((User)session.getAttribute("user"));
		if(usr != null ) {
			List<Partie> listPartie = new ArrayList<Partie>();
			
			listPartie = partieDao.lister(usr.getUserId());
	        request.setAttribute("liste", listPartie);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/historique.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
