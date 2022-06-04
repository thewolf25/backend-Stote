package org.ecommerce.dao;

import java.util.List;

import org.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource()
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByName(String name);
	
}
