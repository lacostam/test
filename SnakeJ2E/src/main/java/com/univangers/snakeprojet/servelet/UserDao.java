package com.univangers.snakeprojet.servelet;
import java.util.List;

public interface UserDao {
    void ajouter( User utilisateur);
    List<User> lister();
}