package com.services.impl;

import com.dtos.ConcertDto;
import com.dtos.SoireeDto;
import com.entities.Concert;
import com.entities.Soiree;
import com.mapper.ConcertMapper;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("concertService")
public class ConcertServiceImpl implements ConcertService {

	private final ConcertRepository concertRepository;


    public ConcertServiceImpl(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto concertDto) {
        // Converts the dto to the concert entity
        Concert concert = concertDtoToEntity(concertDto);
        // Save the concert entity
        concert = concertRepository.save(concert);
        // Return the new dto
        return concertEntityToDto(concert);
    }

    /**
     * Maxence Th
     * @param concertId
     * @param concertDto
     * @return
     */
    @Override
    public ConcertDto uptConcert(Long concertId, ConcertDto concertDto){
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        concert.setDate_debut(concertDto.getDate_debut());
        concert.setDate_fin(concertDto.getDate_fin());
        concert = concertDtoToEntity(concertDto);
        concert = concertRepository.save(concert);
        /*Supprime le concert créer avec save*/
        concertRepository.deleteById(concert.getId());
        return concertEntityToDto(concert);
    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }



    /**
     * Map concert dto to concert entity
     */
    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());
        concertDto.setDate_debut(concert.getDate_debut());
        concertDto.setDate_fin(concert.getDate_fin());
        return concertDto;
    }

    /**
     * Map concert entity to concert dto
     */
    private Concert concertDtoToEntity(ConcertDto concertDto){
        Concert concert = new Concert();
        concert.setDate_debut(concertDto.getDate_fin());
        concert.setDate_fin(concertDto.getDate_fin());
        return concert;
    }
}
