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
	private String category;
	private String colour;
	private Double price;
	private String imageURL;

	public Glasses() {
		// Default constructor
	}

	public Glasses(Long id, String name, String shape, String brand, String category, String colour, Double price, String imageURL) {
		this.id = id;
		this.name = name;
		this.shape = shape;
		this.brand = brand;
		this.category = category;
		this.colour = colour;
		this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Glasses{" +
				"id=" + id +
				", name='" + name + '\'' +
				", shape='" + shape + '\'' +
				", brand='" + brand + '\'' +
				", category='" + category + '\'' +
				", colour='" + colour + '\'' +
				", price=" + price +
				", imageURL='" + imageURL + '\'' +
				'}';
	}
}
