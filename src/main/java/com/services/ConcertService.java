package com.services;

import com.dtos.ConcertDto;

import java.util.List;

public interface ConcertService {
    /**
     * Sauve a concert
     */
    ConcertDto saveConcert(ConcertDto concertDto);

    /**
     * Get a concert by it's id
     */
    ConcertDto getConcertById(Long concertId);

    /**
     * Delete a concert by it's id
     */
    boolean deleteConcert(Long concertId);

    /**
     * Get all the concerts
     */
    List<ConcertDto> getAllConcerts();

    /**
     * Update a concert
     */
    ConcertDto uptConcert(Long concertId, ConcertDto concertDto);

}
