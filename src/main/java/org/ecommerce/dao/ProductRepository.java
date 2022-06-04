package org.ecommerce.dao;

import java.util.List;

import org.ecommerce.entities.Category;
import org.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//@CrossOrigin("*")

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public List<Product> findBySelectedIsTrue();
	
	public List<Product>findByCategory(Category category);
	
}
