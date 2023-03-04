package com.univangers.snakeprojet.dao;
import java.util.List;

import com.univangers.snakeprojet.entity.Partie;


public interface PartieDao {
	void ajouter( Partie partie);
    List<Partie> lister();
    List<Partie> lister(int idClient);

}
