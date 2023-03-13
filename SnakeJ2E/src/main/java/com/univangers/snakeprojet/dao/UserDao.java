package com.univangers.snakeprojet.dao;
import java.util.List;

import com.univangers.snakeprojet.entity.User;

public interface UserDao {
    void ajouter( User utilisateur);
    void delete( User utilisateur);
    List<User> lister();
}