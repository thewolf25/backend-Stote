package org.ecommerce.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	private double currentPrice;
	private boolean promotion;
	private boolean selected;
	private int stock;
	private boolean inStock;
	private String photoName;
	@ManyToOne
	private Category category;

	@OneToMany
	private List<OrderDetails> orderDetails;

	public boolean inStock(){
		return (this.stock > 0 )?true:false;
	}

}
