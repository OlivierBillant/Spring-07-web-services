package com.example.Spring07webservice.dal;

import org.springframework.data.repository.CrudRepository;

import com.example.Spring07webservice.bo.Entreprise;

public interface EntrepriseDao extends CrudRepository<Entreprise, Integer> {

}
