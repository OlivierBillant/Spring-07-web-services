package com.example.Spring07webservice.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@NoArgsConstructor
	//@AllArgsConstructor
	@Entity
	public class Personne {
		@Id
		@GeneratedValue
		private Integer idContact;
		private String nom;
		private String prenom;
		private String tel;
		
		@ManyToOne // il faudra une sauvegarde l'entreprise
		private Entreprise entreprise;
		
		@ManyToMany(cascade = CascadeType.PERSIST)
		private Set<Adresse> listeAdresse = new HashSet<Adresse>();
		
//		On n'utilise pas le @AllArgsConstr car on veut un constructeur san l'id.
		public Personne(String nom, String prenom, String tel) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.tel = tel;
		}
}
