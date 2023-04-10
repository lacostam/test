package com.univangers.snakeprojet.entity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ConnexionForm {
	
	private User connectedUser;
    
	public boolean verifierIdentifiants(User usr,List<User> users) {
		boolean conn=false;
		for(User user : users) {
			if(usr.getPassword().equals(user.getPassword()) && usr.getPseudo().equals(user.getPseudo())) {
				conn=true;
				connectedUser=user;
			}
		}
		return conn;
	}
	
	public boolean verifierPseudo(String pseudo,List<User> users) {
		boolean dejaUtilise=false;
		for(User user : users) {
			if( pseudo.equals(user.getPseudo())) {
				dejaUtilise=true;
			}
		}
		return dejaUtilise;
	}
	
	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}
	
	
}
