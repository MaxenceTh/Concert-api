package com.services.impl;

import com.dtos.ConcertDto;
import com.dtos.DogDto;
import com.dtos.SoireeDto;
import com.entities.Dog;
import com.entities.Soiree;
import com.repositories.DogRepository;
import com.repositories.SoireeRepository;
import com.services.SoireeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("soireeService")
public class SoireeServiceImpl implements SoireeService {

	private final SoireeRepository soireeRepository;

    public SoireeServiceImpl(SoireeRepository soireeRepository){
        this.soireeRepository = soireeRepository;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        // Converts the dto to the dog entity
        Soiree soiree = soireeDtoToEntity(soireeDto);
        // Save the dog entity
        soiree = soireeRepository.save(soiree);
        // Return the new dto
        return soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(Long soireeId) {
        Soiree soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("Soiree not found"));
        return soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(Long soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }

    @Override
    public List<SoireeDto> getAllSoirees() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }

    /**
     * Map soiree dto to soiree entity
     */
    private SoireeDto soireeEntityToDto(Soiree soiree){
        SoireeDto soireeDto = new SoireeDto();
        soireeDto.setId(soiree.getId());
        soireeDto.setNom(soiree.getNom());
        soireeDto.setPrix(soiree.getPrix());
        //Récupère la liste des concerts et pour chaque concerts retourne un objet ConcertDto
        List<ConcertDto> concertDtos = soiree.getConcerts().stream()
                .map(concert -> {
                    ConcertDto concertDto = new ConcertDto();
                    concertDto.setId(concert.getId());
                    concertDto.setDate_debut(concert.getDate_debut());
                    concertDto.setDate_fin(concert.getDate_fin());
                    return concertDto;
                }).collect(Collectors.toList());
        soireeDto.setConcerts(concertDtos);
        return soireeDto;
    }

    /**
     * Map soiree entity to soiree dto
     */
    private Soiree soireeDtoToEntity(SoireeDto soireeDto){
        Soiree soiree = new Soiree();
        soiree.setNom(soireeDto.getNom());
        soiree.setId(soireeDto.getId());
        soiree.setPrix(soireeDto.getPrix());
        return soiree;
    }
}
/**
 * Maxence
 */
 /* for(Soiree soiree : soirees){
            SoireeDto soireeDto = new SoireeDto();
            soireeDto.setId(soiree.getId());
            soireeDto.setPrix(soiree.getPrix());
            soireeDto.setNom(soiree.getNom());
            List<ConcertDto> concertDtos = soiree.getConcerts().stream()
                    .map(concert -> {
                        ConcertDto concertDto = new ConcertDto();
                        concertDto.setId(concert.getId());
                        concertDto.setDate_debut(concert.getDate_debut());
                        concertDto.setDate_fin(concert.getDate_fin());
                        return concertDto;
                    }).collect(Collectors.toList());
            soireeDto.setConcerts(concertDtos);
            soireeDtos.add(soireeDto);
        }*/