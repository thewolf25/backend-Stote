package org.ecommerce.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.ecommerce.entities.Product;
import org.ecommerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
//@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	
	@GetMapping("/category/{name}")
	public List<Product> getProductsByCategory(@PathVariable("name") String name){
		return productService.productsByCategory(name);
	}

	@PostMapping(path = "/uploadPhoto/{id}")
	public ResponseEntity<String> uploadPhoto( MultipartFile file , @PathVariable Long id) throws IOException {

		byte[] bytes = file.getBytes();
		Path path = Paths.get("D:/tekup_project_jee/ecommerce-angular/src/assets/"+id+file.getOriginalFilename()) ;
		Files.write(path, bytes);
		return this.productService.changePhoto(id,file.getOriginalFilename());

	}


	
	@ExceptionHandler
	public ResponseEntity<String> handelexeption(RuntimeException r){
		return new ResponseEntity<String>(r.getMessage(),HttpStatus.NOT_FOUND);
	}
}
