package com.univangers.snakeprojet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.univangers.snakeprojet.entity.Partie;
import com.univangers.snakeprojet.entity.User;

public class PartieDaoImpl implements PartieDao{
	
	private DaoFactory daoFactory;

	PartieDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
	
	
    
	@Override
	public void ajouter(Partie partie) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO PARTIE(user_id, score) VALUES(?, ?);");
            preparedStatement.setInt(1, partie.getPartieId());
            preparedStatement.setInt(2, partie.getScore());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Partie> lister() {
		
		 List<Partie> listPartie = new ArrayList<Partie>();
	     Connection connexion = null;
	     Statement statement = null;
	     ResultSet resultat = null;

	     try {
	    	 connexion = daoFactory.getConnection();
	         statement = connexion.createStatement();
	         resultat = statement.executeQuery("SELECT pseudo, MAX(score) AS score FROM PARTIE JOIN USER U ON U.user_id=PARTIE.user_id GROUP BY pseudo ORDER BY score DESC;");
	         
	         while (resultat.next()) {
	        	 
	             String pseudo = resultat.getString("pseudo");
	             int score = resultat.getInt("score");
	                 
	             Partie partie = new Partie(); 
	             partie.setScore(score); 
	             partie.setPseudo(pseudo);
	       
	             listPartie.add(partie); 
	        }
	     }catch (SQLException e) {
	    	 e.printStackTrace();
	     }
	     return listPartie;
	}

}
