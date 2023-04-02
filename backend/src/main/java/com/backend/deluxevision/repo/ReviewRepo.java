package com.backend.deluxevision.repo;

import com.backend.deluxevision.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    void deleteReviewByReviewId(Long reviewId);

}
