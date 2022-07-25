package com.example.Spring07webservice.bo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("PME")
public class Pme extends Entreprise {
	private Integer chiffreAffaire;

	public Pme(String nom, Integer effectif, Integer chiffreAffaire) {
		super(nom, effectif);
		this.chiffreAffaire = chiffreAffaire;
	}
	
	
}
