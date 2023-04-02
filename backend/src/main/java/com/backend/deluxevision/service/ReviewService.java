package com.backend.deluxevision.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.backend.deluxevision.model.Review;
import com.backend.deluxevision.repo.ReviewRepo;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public Review addReview(Review review) {
        review.setReviewId(new Random().nextLong());
        return reviewRepo.save(review);
    }

    @Transactional
    public void deleteReviewByReviewId(Long id) {
        reviewRepo.deleteReviewByReviewId(id);
    }

    public List<Review> findAllReviews() {
        return reviewRepo.findAll();
    }

}
