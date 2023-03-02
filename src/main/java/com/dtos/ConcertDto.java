package com.dtos;


import com.entities.Soiree;
import lombok.Data;

import java.time.LocalDate;


@Data
public class ConcertDto {

	private Long Id;
	private LocalDate date_debut;
	private LocalDate date_fin;



	
}
