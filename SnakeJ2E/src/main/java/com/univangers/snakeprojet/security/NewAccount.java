package com.univangers.snakeprojet.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.univangers.snakeprojet.dao.DaoFactory;
import com.univangers.snakeprojet.dao.UserDao;
import com.univangers.snakeprojet.entity.User;

/**
 * Servlet implementation class NewAccount
 */
@WebServlet("/NewAccount")
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccount() {
        super();
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/newAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionForm form = new ConnectionForm();
		boolean exist=form.verifierPseudo(request.getParameter("pseudo"),userDao.lister());
		if(!exist) {
			String pseudo=request.getParameter("pseudo");
			String password=request.getParameter("password");
			User usr= new User();
			usr.setPseudo(pseudo);
			usr.setPassword(password);
			userDao.ajouter(usr);
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}else{
	        request.setAttribute("error", "Pseudo déja utilisé");
			this.getServletContext().getRequestDispatcher("/WEB-INF/newAccount.jsp").forward(request, response);
		}
	}

}
