package com.backend.deluxevision.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Review implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long reviewId;
    private Long glassesId;
    private String review;

    public Review() {
        // Default constructor
    }

    public Review(Long reviewId, Long glassesId, String review) {
        this.reviewId = reviewId;
        this.glassesId = glassesId;
        this.review = review;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(Long glassesId) {
        this.glassesId = glassesId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", glassesId=" + glassesId +
                ", review='" + review + '\'' +
                '}';
    }
}
