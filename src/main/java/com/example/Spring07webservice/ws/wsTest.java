package com.example.Spring07webservice.ws;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.Spring07webservice.bo.Adresse;
import com.example.Spring07webservice.bo.Entreprise;
import com.example.Spring07webservice.bo.Personne;
import com.example.Spring07webservice.bo.Pme;
import com.example.Spring07webservice.dal.EntrepriseDao;
import com.example.Spring07webservice.dal.PersonneDao;

@RestController
public class wsTest {
	@Autowired
	private EntrepriseDao entrepriseDao;
	@Autowired
	private PersonneDao personneDao;

	@GetMapping("/hello")
	public String sayHi() {
		return "Hello";
	}

	@GetMapping("/hello/{lang}")
	public String disHello2(@PathVariable("lang") String lang) {
		if ("FR".equals(lang)) {
			return "Bonjour";
		} else {
			return "Hello";
		}
	}

	@GetMapping("/hello/age/{age}")
	public String disHello3(@PathVariable("age") Integer age) {
		if (age < 18) {
			return "Whesh mec !!";
		} else {
			return "Bonjour monsieur";
		}
	}

	@GetMapping("/quiestu")
	public Personne quiEstTu() {
		return new Personne("Cérien", "Jean", "0606060606");
	}

	@GetMapping("/liste-contacts")
	public ArrayList<Personne> getAllContacts() {
		Entreprise entreprise = new Entreprise("Next2", 5);
		entrepriseDao.save(entreprise);
		Personne jean = new Personne("Cérien", "Jean", "000244");
		Adresse a1 = new Adresse("Rue du Rosier", "Laval", "53000");
		Adresse a2 = new Adresse("Rue du Roseau", "Quimper", "29000");
		jean.getListeAdresse().add(a1);
		jean.getListeAdresse().add(a2);

		entreprise.addContact(jean);
		personneDao.save(jean);
		return (ArrayList<Personne>) personneDao.findAll();
	}

	@GetMapping("/liste-entreprises")
	public ArrayList<Entreprise> getAllEntreprises() {
		Entreprise entreprise1 = new Entreprise("Next2", 5);
		Entreprise entreprise2 = new Entreprise("Next2", 5);
		Entreprise entreprise3 = new Entreprise("Next2", 5);
		Pme entreprise4 = new Pme("Next2", 5, 10000);
		entrepriseDao.save(entreprise1);
		entrepriseDao.save(entreprise2);
		entrepriseDao.save(entreprise3);
		entrepriseDao.save(entreprise4);
		return (ArrayList<Entreprise>) entrepriseDao.findAll();
	}

}
