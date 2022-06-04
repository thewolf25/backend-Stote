package org.ecommerce.services;

import java.util.List;

import org.ecommerce.dao.CategoryRepository;
import org.ecommerce.dao.ProductRepository;
import org.ecommerce.entities.Category;
import org.ecommerce.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> productsByCategory(String name) {
		// TODO Auto-generated method stub
		Category c = (Category) categoryRepository.findByName(name);
		List<Product> listP = productRepository.findByCategory(c);
		System.out.println(listP);
		if ( listP.isEmpty())
			throw new RuntimeException("pas de produit pour ce categorie !!!!!");
		else
			return listP;
	}

	@Override
	public ResponseEntity<String> changePhoto(Long id, String photo) {
		Product p = this.productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not found !!!"));
		p.setPhotoName(id+photo);
		this.productRepository.save(p);
		return new ResponseEntity<String>("photo modifier avec succées", HttpStatus.OK);
	}


}
