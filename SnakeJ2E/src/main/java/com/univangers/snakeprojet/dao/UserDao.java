package com.univangers.snakeprojet.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.univangers.snakeprojet.entity.User;

public interface UserDao {
    void ajouter( HttpServletRequest request) throws DaoException;
    void delete( HttpServletRequest reques);
    List<User> lister();
	void connexion(HttpServletRequest request) throws DaoException;
}