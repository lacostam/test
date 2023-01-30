package com.univangers.snakeprojet.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.univangers.snakeprojet.dao.DaoFactory;
import com.univangers.snakeprojet.dao.UserDao;
import com.univangers.snakeprojet.entity.User;

/**
 * Servlet implementation class ConnectionSnake
 */
@WebServlet("/ConnexionSnake")
public class ConnexionSnake extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionSnake() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	    String pseudo = request.getParameter("pseudo");
	    String password = request.getParameter("password");
	    ConnexionForm form = new ConnexionForm();
		User usr = new User();
		usr.setPseudo(request.getParameter("pseudo"));
		usr.setPassword(request.getParameter("password"));
		boolean conn=form.verifierIdentifiants(usr,userDao.lister());
		if(conn) {
			System.out.println(usr.getPseudo()+" connecté");
			response.sendError(200,"OK");
		}else {
			System.out.println("identifiant incorect");
			response.sendError(401,"Connexion impossible");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
