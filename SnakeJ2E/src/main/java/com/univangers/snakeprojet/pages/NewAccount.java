package com.univangers.snakeprojet.pages;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User usr = ((User)session.getAttribute("user"));
		if(usr != null ) {
			response.sendRedirect(request.getContextPath() + "/Profil");
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/newAccount.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			userDao.ajouter(request);
		}catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
		if(request.getAttribute("error")==null) {
			response.sendRedirect(request.getContextPath() + "/Login");
		}else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/newAccount.jsp").forward(request, response);
		}
	}

}
