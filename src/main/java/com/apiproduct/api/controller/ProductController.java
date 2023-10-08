package com.apiproduct.api.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiproduct.api.model.Product;
import com.apiproduct.api.service.ProductService;



@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	/**
	 * Create - Add a new product
	 * @param product An object product
	 * @return The product object saved
	 */
	@PostMapping("/product")
	public Product createProduct (@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	/**
	 * Read - Get one product 
	 * @param id The id of the product
	 * @return An Product object full filled
	 */
	@GetMapping("/product/{id}")
	public Product getProduct (@PathVariable("id") final Long id) {
		Optional<Product> product = productService.getProduct(id);
		if(product.isPresent()) {
			return product.get();
		}else {
			return null;
		}
	}
	
	
	/**
	 * Read - Get all products
	 * @return - An Iterable object of Product full filled
	 */
	@GetMapping("/products")
	public Iterable<Product> getProducts() {
		return productService.getProducts();
	}
	
	
	
	/**
	 * Update - Update an existing product
	 * @param id - The id of the product to update
	 * @param product - The product object updated
	 * @return
	 */
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable("id") final Long id, @RequestBody Product product) {
		Optional<Product> e = productService.getProduct(id);
		if(e.isPresent()) {
			Product currentProduct = e.get();
			
			String code = product.getCode();
			if(code != null) {
				currentProduct.setCode(code);
			}
			
			String name = product.getName();
			if(name != null) {
				currentProduct.setName(name);
			}
			
			String description = product.getDescription();
			if(description != null) {
				currentProduct.setDescription(description);
			}
			
			String image = product.getImage();
			if(image != null) {
				currentProduct.setImage(image);
			}
			
			

			Double price = product.getPrice();
			if(price != null) {
				currentProduct.setPrice(price);
			}
			
			
			String category = product.getCategory();
			if(category != null) {
				currentProduct.setCategory(category);
			}
			
			
			Integer quantity = product.getQuantity();
			if(quantity != null) {
				currentProduct.setQuantity(quantity);
			}
			
			String inventoryStatus = product.getInventoryStatus();
			if(inventoryStatus != null) {
				currentProduct.setInventoryStatus(inventoryStatus);
			}
			
			Long rating = product.getRating();
			if(rating != null) {
				currentProduct.setRating(id);
			
		}
			productService.saveProduct(currentProduct);
			return currentProduct;
		}else {
				return null;
			
		}
	}
	
	
	
	/**
	 * Delete - Delete an product
	 * @param id - The id of the product to delete
	 */
	@DeleteMapping("/product/{id}")
	public void deletProduct(@PathVariable("id") final Long id) {
		productService.deleteProduct(id);
	}
	
	
	
}
