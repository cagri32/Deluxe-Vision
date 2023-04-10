package com.backend.deluxevision.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.backend.deluxevision.model.Review;
import com.backend.deluxevision.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

/*import com.backend.deluxevision.exception.GlassesNotFoundException;
*/
import com.backend.deluxevision.model.Glasses;
import com.backend.deluxevision.repo.GlassesRepo;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GlassesService {
	private final GlassesRepo glassesRepo;
	private final ReviewRepo reviewRepo;

	@Autowired
	public GlassesService(GlassesRepo glassesRepo, ReviewRepo reviewRepo) {
		this.glassesRepo = glassesRepo;
		this.reviewRepo = reviewRepo;
	}


	public Glasses addGlasses(Glasses glasses) {
		return glassesRepo.save(glasses);
	}

	public List<Glasses> findAllGlasses() {
		return glassesRepo.findAll();
	}

/*
	public Glasses updateGlasses(Glasses glasses) {
		return glassesRepo.save(glasses);
	}
*/

	public void updateGlasses(Glasses updatedGlasses) {
		// find the glasses with the same name
		Optional<Glasses> optionalGlasses = glassesRepo.findGlassesByName(updatedGlasses.getName());

		if (optionalGlasses.isPresent()) {
			// replace the old glasses with the one that comes in the parameter using set functions
			Glasses oldGlasses = optionalGlasses.get();
			oldGlasses.setShape(updatedGlasses.getShape());
			oldGlasses.setBrand(updatedGlasses.getBrand());
			oldGlasses.setColour(updatedGlasses.getColour());
			oldGlasses.setPrice(updatedGlasses.getPrice());
			oldGlasses.setImageURL(updatedGlasses.getImageURL());

			glassesRepo.save(oldGlasses);
		}
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

	public List<Review> getReviewsByGlassesId(Long glassesId) {
		return reviewRepo.findByGlassesId(glassesId);
	}
	public List<Glasses> getGlassesByCategory(String category) {
		return glassesRepo.getGlassesByCategory(category);
	}

//	public List getTopTenGlasses() {
//		return glassesRepo.getTopTenGlasses();
//	}
	public void addReview(@RequestBody Review review) {
		reviewRepo.save(review);
	}
/*

	@GetMapping("/getreport")
	public List getReport(){
		return glassesRepo.getGlassesReport();
	}
*/


}


