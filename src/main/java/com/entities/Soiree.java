package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="t_soiree_soi")
public class Soiree {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="soi_id")
	private Long Id;
	@Column(name="soi_nom")
	private String nom;
	@Column(name="soi_prix")
	private double prix;
	@ManyToOne
	@JoinColumn(name = "sal_id")
	private Salle salle;

	@OneToMany(mappedBy = "soiree")
	private List<Concert> concerts = new ArrayList<>();

	
}
