package com.services;

import com.dtos.SoireeDto;
import java.util.List;

public interface SoireeService {
    /**
     * Sauve a soiree
     */
    SoireeDto saveSoiree(SoireeDto SoireeDto);

    /**
     * Get a soiree by it's id
     */
    SoireeDto getSoireeById(Long SoireeId);

    /**
     * Delete a soiree by it's id
     */
    boolean deleteSoiree(Long SoireeId);

    /**
     * Get all the soirees
     */
    List<SoireeDto> getAllSoirees();


}
