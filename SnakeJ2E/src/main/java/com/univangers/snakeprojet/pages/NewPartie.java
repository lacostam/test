package com.univangers.snakeprojet.pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univangers.snakeprojet.dao.DaoFactory;
import com.univangers.snakeprojet.dao.PartieDao;
import com.univangers.snakeprojet.entity.Partie;
import com.univangers.snakeprojet.entity.User;
import com.univangers.snakeprojet.security.ConnexionForm;

/**
 * Servlet implementation class NewPartie
 */
@WebServlet("/NewPartie")
public class NewPartie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PartieDao partieDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPartie() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.partieDao = daoFactory.getPartieDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    int idClient = Integer.parseInt(request.getParameter("idClient"));
	    int score = Integer.parseInt(request.getParameter("score"));
		Partie p = new Partie();
		p.setIdClient(idClient);
		p.setScore(score);
		partieDao.ajouter(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
