package com.entities;

import com.dtos.SoireeDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="t_salle_sal")
public class Salle {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sal_id")
	private Long Id;
	@Column(name="sal_nom")
	private String nom;
	@Column(name="sal_adresse")
	private String adresse;
	@Column(name="sal_capacite")
	private int capacite;
	@Column(name="sal_association")
	private String association;
	@Column(name="sal_nom_gest")
	private String nom_gestionnaire;
	@Column(name="sal_prenom_gest")
	private String prenom_gestionnaire;

	@OneToMany(mappedBy = "salle")
	private List<Soiree> soirees = new ArrayList<>();



	
}
