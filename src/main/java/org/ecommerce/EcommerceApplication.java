package org.ecommerce;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.ecommerce.dao.CategoryRepository;
import org.ecommerce.dao.ProductRepository;
import org.ecommerce.entities.Category;
import org.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.bytebuddy.utility.RandomString;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		File folder1 = new File("D:/Download/MW-Steal his holdie/Nouveau dossier");
		File folder2 = new File("D:/Download/MW-Steal his holdie/shos");
		File[] hoodies = folder1.listFiles();
		File[] shoes = folder2.listFiles();

		for(File s: hoodies){
			System.out.println(s.getName());
		}
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
		Random rd = new Random();
		categoryRepository.save(new Category((long) 1, "Hoodies", "laptop products","unknown.jpg",null));
		categoryRepository.save(new Category((long) 2, "Shoes", "All Accessoires","unknown.jpg",null));
		categoryRepository.findAll().forEach(
				(c)->
				{
					if(c.getName().equals("Hoodies")){
						for(File h: hoodies){
					Product p = new Product();
					p.setNom(h.getName().substring(0,h.getName().length()-4));
					p.setCurrentPrice(rd.nextInt(5)+rd.nextDouble());
					p.setInStock(rd.nextBoolean());
					p.setSelected(rd.nextBoolean());
					p.setPhotoName(h.getName());
					p.setCategory(c);
					productRepository.save(p);
					}
					}
					else{
						for(File s: shoes){
							Product p = new Product();
							p.setNom(s.getName().substring(0,s.getName().length()-4));
							p.setCurrentPrice(rd.nextInt(5)+rd.nextDouble());
							p.setInStock(rd.nextBoolean());
							p.setSelected(rd.nextBoolean());
							p.setPhotoName(s.getName());
							p.setCategory(c);
							productRepository.save(p);
						}
					}
				}
				);
	
	}

}
