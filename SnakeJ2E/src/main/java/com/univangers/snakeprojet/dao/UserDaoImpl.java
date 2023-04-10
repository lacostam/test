package com.univangers.snakeprojet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.univangers.snakeprojet.entity.ConnexionForm;
import com.univangers.snakeprojet.entity.User;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(HttpServletRequest request) throws DaoException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        ConnexionForm form = new ConnexionForm();
		
		String pseudo=request.getParameter("pseudo");
		String password=request.getParameter("password");
		
		boolean existdeja = form.verifierPseudo(pseudo,this.lister());
		if(existdeja) {
			throw new DaoException("Pseudo deja utilisé");
		}else if(password.isBlank() || pseudo.isBlank()){
			throw new DaoException("Les champs pseudo et password sont obligatoires");
		}else if(password.length()<5){
			throw new DaoException("Mot de passe trop court (<5)");
		}else {
		
			User usr= new User();
			usr.setPseudo(pseudo);
			usr.setPassword(password);
	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO USER(pseudo, password) VALUES(?, ?);");
	            preparedStatement.setString(1, usr.getPseudo());
	            preparedStatement.setString(2, usr.getPassword());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
    }

    @Override
    public List<User> lister() {
        List<User> utilisateurs = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT user_id,pseudo, password FROM USER;");

            while (resultat.next()) {
            	 int user_id = resultat.getInt("user_id");
                 String pseudo = resultat.getString("pseudo");
                 String password = resultat.getString("password");
                 
                 User utilisateur = new User();
                 utilisateur.setUserId(user_id);
                 utilisateur.setPseudo(pseudo);
                 utilisateur.setPassword(password);
                 
                 utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

	@Override
	public void delete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User utilisateur = ((User) request.getSession().getAttribute("user"));
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(" DELETE FROM USER WHERE pseudo=? AND password=?;");
            preparedStatement.setString(1, utilisateur.getPseudo());
            preparedStatement.setString(2, utilisateur.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no");

        }
	}

	
	@Override
	public void connexion(HttpServletRequest request) throws DaoException {
		// TODO Auto-generated method stub
		ConnexionForm form = new ConnexionForm();
		User usr = new User();
		usr.setPseudo(request.getParameter("pseudo"));
		usr.setPassword(request.getParameter("password"));
		boolean conn=form.verifierIdentifiants(usr,this.lister());
		if(request.getParameter("pseudo").isBlank() || request.getParameter("password").isBlank()) {
			throw new DaoException("Les champs pseudo et password sont obligatoires");
		}else if(!conn ){
			throw new DaoException("Identifiants incorrect");
		} else {
			HttpSession session = request.getSession();
	        session.setAttribute("user", form.getConnectedUser());
		}
	}

}