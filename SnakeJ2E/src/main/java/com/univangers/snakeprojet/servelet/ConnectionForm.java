package com.univangers.snakeprojet.servelet;

import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {
	private String resultat;

	public void verifierIdentifiants(HttpServletRequest request) {
		String login= request.getParameter("pseudo");
		String password= request.getParameter("password");
		if(password.equals(login+"123")) {
			resultat="Vous êtes connecté !";
		}else {
			resultat="Identifiants incorrects !";
		}

	}
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
}
