package org.ecommerce.services;

import java.util.List;

import org.ecommerce.entities.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {
	
	List<Product>getProduct();
	List<Product> productsByCategory(String name);
	ResponseEntity<String> changePhoto(Long id, String photo);
	
	
}
