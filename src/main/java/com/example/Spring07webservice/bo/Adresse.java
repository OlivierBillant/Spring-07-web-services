package com.example.Spring07webservice.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Adresse {
	@Id
	@GeneratedValue
	private Integer idAdresse;
	private String rue;
	private String ville;
	private String cp;

	@ManyToMany(mappedBy = "listeAdresse")
	private Set<Personne> listeContact = new HashSet<Personne>();

	public Adresse(String rue, String ville, String cp) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.cp = cp;
	}
	
	
}
