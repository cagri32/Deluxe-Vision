package com.backend.deluxevision.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.deluxevision.model.Glasses;
import com.backend.deluxevision.service.GlassesService;

@RestController
@RequestMapping("/glasses")
public class GlassesController {
	private final GlassesService glassesService;

	public GlassesController(GlassesService glassesService) {
		this.glassesService = glassesService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Glasses>> getAllGlasses() {
		List<Glasses> glasses = glassesService.findAllGlasses();
		return new ResponseEntity<>(glasses, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Glasses> getGlassesById(@PathVariable("id") Long id) throws NotFoundException {
		Glasses glasses = glassesService.findGlassesById(id);
		return new ResponseEntity<>(glasses, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Glasses> addGlasses(@RequestBody Glasses glasses) {
		Glasses newGlasses = glassesService.addGlasses(glasses);
		return new ResponseEntity<>(newGlasses, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Glasses> updateGlasses(@RequestBody Glasses glasses) {
		Glasses newGlasses = glassesService.updateGlasses(glasses);
		return new ResponseEntity<>(newGlasses, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Glasses> updateGlasses(@RequestBody Glasses glasses, Long id) throws NotFoundException {
		Glasses newGlasses = glassesService.updateGlasses(glasses, id);
		return new ResponseEntity<>(newGlasses, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGlasses(@PathVariable("id") Long id) {
		glassesService.deleteGlassesById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}