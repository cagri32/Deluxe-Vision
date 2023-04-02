package com.backend.deluxevision.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Glasses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String shape;
	private String brand;
	private String colour;
	private Double price;
	private String imageURL;

	@Column(nullable = false, updatable = false)
	private String glassesCode;

	public Glasses() {
		// Default constructor
	}

	public Glasses(String name, String shape, String imageURL) {
		this.name = name;
		this.shape = shape;
		this.imageURL = imageURL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getGlassesCode() {
		return glassesCode;
	}

	public void setGlassesCode(String glassesCode) {
		this.glassesCode = glassesCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Glasses{" +
				"id=" + id +
				", id=" + id +
				", name='" + name + '\'' +
				", shape='" + shape + '\'' +
				", brand='" + brand + '\'' +
				", colour='" + colour + '\'' +
				", price='" + price + '\'' +
				", imageURL='" + imageURL + '\'' +
				", glassesCode='" + glassesCode + '\'' +
				'}';
	}
}
