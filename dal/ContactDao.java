package fr.eni.Spring04demoData.dal;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.eni.Spring04demoData.bo.Contact;

public interface ContactDao extends CrudRepository<Contact, Integer> {

	@Query("SELECT a.ville FROM Contact c JOIN c.listeAdresse a WHERE c= :contact")
	ArrayList<String> getVilleFomrContact(@Param("contact") Contact contact);

}
