package com.services.impl;


import com.dtos.ConcertDto;
import com.dtos.SalleDto;
import com.dtos.SoireeDto;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.SalleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("salleService")
public class SalleServiceImpl implements SalleService {

	private final SalleRepository salleRepository;


    public SalleServiceImpl(SalleRepository salleRepository){
        this.salleRepository = salleRepository;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        // Converts the dto to the salle entity
        Salle salle = salleDtoToEntity(salleDto);
        // Save the salle entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleEntityToDto(salle));
        });
        return salleDtos;
    }


   @Override
    public List<SalleDto> getAllSoireesFromSalle() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();

        for (Salle salle : salles) {
            SalleDto salleDto = new SalleDto();
            salleDto.setId(salle.getId());
            salleDto.setNom(salle.getNom());
            salleDto.setAdresse(salle.getAdresse());
            salleDto.setCapacite(salle.getCapacite());
            salleDto.setAssociation(salle.getAssociation());
            salleDto.setNom_gestionnaire(salle.getNom_gestionnaire());
            salleDto.setPrenom_gestionnaire(salle.getPrenom_gestionnaire());
            //Récupère la liste des soirées et pour chaque soirée retourne un objet SoireeDto
            List<SoireeDto> soireeDtos = salle.getSoirees().stream()
                    .map(soiree -> {
                        SoireeDto soireeDto = new SoireeDto();
                        soireeDto.setId(soiree.getId());
                        soireeDto.setNom(soiree.getNom());
                        soireeDto.setPrix(soiree.getPrix());
                        return soireeDto;
                    }).collect(Collectors.toList());

            salleDto.setSoirees(soireeDtos);
            salleDtos.add(salleDto);
        }

        return salleDtos;
    }



    /**
     * Map salle dto to salle entity
     */
    private SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setNom(salle.getNom());
        salleDto.setAdresse(salle.getAdresse());
        salleDto.setCapacite(salle.getCapacite());
        salleDto.setAssociation(salle.getAssociation());
        salleDto.setNom_gestionnaire(salle.getNom_gestionnaire());
        salleDto.setPrenom_gestionnaire(salle.getPrenom_gestionnaire());
        /*
        Récupère la liste des soirées dans une salle / pour chaque soirée retourne un objet SoireeDto
         */
        List<SoireeDto> soireeDtos = salle.getSoirees().stream()
                .map(soiree -> {
                    SoireeDto soireeDto = new SoireeDto();
                    soireeDto.setId(soiree.getId());
                    soireeDto.setNom(soiree.getNom());
                    soireeDto.setPrix(soiree.getPrix());
                    /*
                    Récupère la liste des concerts dans une soirée / retourne un objet ConcertDto
                     */
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
                }).collect(Collectors.toList());

        salleDto.setSoirees(soireeDtos);
        return salleDto;
    }

    private SalleDto salleEntityToDtoV2(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setNom(salle.getNom());
        salleDto.setAdresse(salle.getAdresse());
        salleDto.setCapacite(salle.getCapacite());
        salleDto.setAssociation(salle.getAssociation());
        salleDto.setNom_gestionnaire(salle.getNom_gestionnaire());
        salleDto.setPrenom_gestionnaire(salle.getPrenom_gestionnaire());

        return salleDto;
    }
    /**
     * Map salle entity to salle dto
     */
    private Salle salleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setNom(salleDto.getNom());
        salle.setAdresse(salleDto.getAdresse());
        salle.setCapacite(salleDto.getCapacite());
        salle.setAssociation(salleDto.getAssociation());
        salle.setNom_gestionnaire(salleDto.getNom_gestionnaire());
        salle.setPrenom_gestionnaire(salleDto.getPrenom_gestionnaire());
        return salle;
    }



}
