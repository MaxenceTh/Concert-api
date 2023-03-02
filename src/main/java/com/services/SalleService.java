package com.services;

import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.SoireeDto;

import java.util.List;

public interface SalleService {
    /**
     * Sauve a dog
     */
    SalleDto saveSalle( SalleDto salleDto);

    /**
     * Get a salle by it's id
     */
    SalleDto getSalleById(Long salleId);

    /**
     * Delete a salle by it's id
     */
    boolean deleteSalle(Long salleId);

    /**
     * Get all the salles
     */
    List<SalleDto> getAllSalles();

    /**
     * Get concert from salle
     */
    List<SalleDto> getAllSoireesFromSalle();


}
