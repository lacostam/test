package com.univangers.snakeprojet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.univangers.snakeprojet.entity.User;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(User utilisateur) {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO USER(pseudo, password) VALUES(?, ?);");
            preparedStatement.setString(1, utilisateur.getPseudo());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
	public void delete(User utilisateur) {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement(" DELETE FROM USER WHERE pseudo=? AND password=?;");
            preparedStatement.setString(1, utilisateur.getPseudo());
            preparedStatement.setString(2, utilisateur.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}


}