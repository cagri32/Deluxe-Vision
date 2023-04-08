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
    private String userName;
    private String fullName;
    private int rating;
    private String title;

    public Review() {
        // Default constructor
    }

    public Review(Long reviewId, Long glassesId, String review, String userName, String fullName, int rating, String title) {
        this.reviewId = reviewId;
        this.glassesId = glassesId;
        this.review = review;
        this.userName = userName;
        this.fullName = fullName;
        this.rating = rating;
        this.title = title;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", glassesId=" + glassesId +
                ", review='" + review + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", rating=" + rating +
                ", title='" + title + '\'' +
                '}';
    }
}
