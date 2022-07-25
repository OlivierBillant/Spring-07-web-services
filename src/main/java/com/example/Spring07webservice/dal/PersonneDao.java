package com.example.Spring07webservice.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.Spring07webservice.bo.Personne;

public interface PersonneDao extends CrudRepository<Personne, Integer> {

	@Query("SELECT a.ville FROM Personne p JOIN p.listeAdresse a WHERE p= :personne")
	ArrayList<String> getVilleFomrContact(@Param("personne") Personne personne);

}
