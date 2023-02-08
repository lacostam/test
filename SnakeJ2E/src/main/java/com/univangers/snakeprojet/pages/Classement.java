package com.univangers.snakeprojet.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univangers.snakeprojet.dao.DaoFactory;
import com.univangers.snakeprojet.dao.PartieDao;
import com.univangers.snakeprojet.dao.UserDao;
import com.univangers.snakeprojet.entity.Partie;

/**
 * Servlet implementation class Classement
 */
@WebServlet("/Classement")
public class Classement extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PartieDao partieDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Classement() throws ServletException {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.partieDao = daoFactory.getPartieDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Partie> listPartie = new ArrayList<Partie>();
		listPartie = partieDao.lister();
		
        request.setAttribute("liste", listPartie);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/classement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
