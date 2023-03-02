package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="t_concert_con")
public class Concert {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="con_id")
	private Long Id;
	@Column(name="con_date_debut")
	private LocalDate date_debut;
	@Column(name="con_date_fin")
	private LocalDate date_fin;

	@ManyToOne
	@JoinColumn(name = "soi_id")
	private Soiree soiree;

	
}
