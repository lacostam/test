package com.univangers.snakeprojet.dao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.univangers.snakeprojet.entity.User;

public interface UserDao {
    void ajouter( HttpServletRequest request) throws DaoException;
    void delete( User utilisateur);
    List<User> lister();
}