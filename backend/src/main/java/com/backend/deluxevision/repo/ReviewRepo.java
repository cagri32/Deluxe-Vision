package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    void deleteReviewByReviewId(Long reviewId);
    List<Review> findByGlassesId(Long glassesId);

    Optional<Review> getReviewByReviewId(Long id);
}
