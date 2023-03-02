package com.controllers;

import com.dtos.SoireeDto;
import com.services.impl.SoireeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {

	private final SoireeServiceImpl soireeService;

	public SoireeController(SoireeServiceImpl soireeService) {
		this.soireeService = soireeService;
	}

	/**
	 * <p>Get all soirees in the system</p>
	 * @return List<SoireeDto>
	 */
	@GetMapping
	public List<SoireeDto> getSoirees() {
		return soireeService.getAllSoirees();
	}

	/**
	 * Method to get the soiree based on the ID
	 */
	@GetMapping("/{id}")
	public SoireeDto getSoiree(@PathVariable Long id){
		return soireeService.getSoireeById(id);
	}

	/**
	 * Create a new Soiree in the system
	 */
	@PostMapping
	public SoireeDto saveSoiree(final @RequestBody SoireeDto soireeDto){
		return soireeService.saveSoiree(soireeDto);
	}

	/**
	 * Delete a soiree by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteSoiree(@PathVariable Long id){
		return soireeService.deleteSoiree(id);
	}



}
