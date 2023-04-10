package com.univangers.snakeprojet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            preparedStatement = connexion.prepareStatement("INSERT INTO PARTIE(user_id,date, score) VALUES(?,CURRENT_TIMESTAMP, ?);");
            preparedStatement.setInt(1, partie.getIdClient());
            preparedStatement.setInt(2, partie.getScore());
    		System.out.println(preparedStatement);
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



	@Override
	public List<Partie> lister(int idClient) {
		 List<Partie> listPartie = new ArrayList<Partie>();
	     Connection connexion = null;
	     Statement statement = null;
	     ResultSet resultat = null;
	       PreparedStatement preparedStatement = null;
	     try {
	    	 connexion = daoFactory.getConnection();
	         statement = connexion.createStatement();	         
         	preparedStatement = connexion.prepareStatement("SELECT date,score FROM PARTIE WHERE PARTIE.user_id=? ORDER BY date DESC;");
            preparedStatement.setInt(1, idClient);
            resultat = preparedStatement.executeQuery();            
	        while (resultat.next()) {
	             int score = resultat.getInt("score");
	             Timestamp date = resultat.getTimestamp("date");
	             Partie partie = new Partie(); 
	             partie.setScore(score); 	   
	             partie.setDate(date);
	             listPartie.add(partie); 
	        }
	     }catch (SQLException e) {
	    	 e.printStackTrace();
	     }
	     return listPartie;
	}

}
