package com.backend.deluxevision.controller;

import com.backend.deluxevision.model.Review;
import com.backend.deluxevision.service.ReviewService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {


    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Review> getReviewByReviewId(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        Review review = reviewService.getReviewByReviewId(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review newReview = reviewService.addReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable("id") Long id) {
        reviewService.deleteReviewByReviewId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
