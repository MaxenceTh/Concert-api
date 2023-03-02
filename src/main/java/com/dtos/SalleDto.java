package com.dtos;


import lombok.Data;

import java.util.List;


@Data
public class SalleDto {

	private Long Id;
	private String nom;
	private String adresse;
	private int capacite;
	private String association;
	private String nom_gestionnaire;
	private String prenom_gestionnaire;

	/**
	 * Liste des soirées
	 */
	List<SoireeDto> soirees;

}
