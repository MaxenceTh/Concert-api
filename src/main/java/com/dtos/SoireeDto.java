package com.dtos;

import com.entities.Concert;
import lombok.Data;

import java.util.List;

@Data
public class SoireeDto {

	private Long Id;
	private String nom;
	private double prix;

	/**
	 * Liste des concerts
	 */
	List<ConcertDto> concerts;

	//Pas de gestion des clés étrangère
}
