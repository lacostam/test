package com.univangers.snakeprojet.servelet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(User utilisateur) {
        

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


}