package com.univangers.snakeprojet.entity;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Partie {
	
	private int partieId; 
	private Timestamp date;
	private int score; 
	private int idClient;
	private String pseudo; 
	
	public int getPartieId() {
		return partieId;
	}
	public void setPartieId(int partieId) {
		this.partieId = partieId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getIdClient() {
		return idClient;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public String getDate() {
		String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(date);
	    return s;
	}
	public void setDate(Timestamp date2) {
		this.date = date2;
	}
	
	
	
	
}
