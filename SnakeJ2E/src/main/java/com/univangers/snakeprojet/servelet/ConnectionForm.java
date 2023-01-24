package com.univangers.snakeprojet.servelet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	
	private User connectedUser;
    
	public boolean verifierIdentifiants(HttpServletRequest request,List<User> users) {
		String pseudo= request.getParameter("pseudo");
		String password= request.getParameter("password");
		boolean conn=false;
		for(User user : users) {
			if(password.equals(user.getPassword()) && pseudo.equals(user.getPseudo())) {
				conn=true;
				connectedUser=user;
			}
		}
		return conn;
	}

	public User getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(User connectedUser) {
		this.connectedUser = connectedUser;
	}
	
	
}
