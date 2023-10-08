package com.apiproduct.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	private String name;
	
	private String description;
	
	private String image;
	
	private Double price;
	
	private String category;
	
	private int quantity;
	
	private String inventoryStatus;
	
	private Long rating;
}
