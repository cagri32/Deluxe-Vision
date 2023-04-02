package com.backend.deluxevision.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

/*import com.backend.deluxevision.exception.GlassesNotFoundException;
*/
import com.backend.deluxevision.model.Glasses;
import com.backend.deluxevision.repo.GlassesRepo;

import jakarta.transaction.Transactional;

@Service
public class GlassesService {
	private final GlassesRepo glassesRepo;

	@Autowired
	public GlassesService(GlassesRepo glassesRepo) {
		this.glassesRepo = glassesRepo;
	}

	public Glasses addGlasses(Glasses glasses) {
		glasses.setGlassesCode(UUID.randomUUID().toString());
		return glassesRepo.save(glasses);
	}

	public List<Glasses> findAllGlasses() {
		return glassesRepo.findAll();
	}

	public Glasses updateGlasses(Glasses glasses) {
		return glassesRepo.save(glasses);
	}

	public Glasses updateGlasses(Glasses glasses, Long id) throws NotFoundException {
		Glasses currGlasses = this.findGlassesById(id);
		currGlasses.setName(glasses.getName());
		currGlasses.setShape(glasses.getShape());
		currGlasses.setImageURL(glasses.getImageURL());

		return glassesRepo.save(glasses);
	}

	public Glasses findGlassesById(Long id) throws NotFoundException {
		/*
		 * return glassesRepo.findGlassesById(id) .orElseThrow(() -> new
		 * GlassesNotFoundException("Glasses by id " + id + " was not found"));
		 */
		Optional<Glasses> glassesOptional = glassesRepo.findGlassesById(id);
		Glasses glasses = glassesOptional.orElseThrow(() -> new NotFoundException());
		return glasses;

	}

	@Transactional
	public void deleteGlassesById(Long id) {
		glassesRepo.deleteGlassesById(id);
	}
}
