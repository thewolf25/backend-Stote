package org.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class OrderDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Couleur;
    private String Size;
    private String Quantity;
    @ManyToOne
    @JoinColumn(name= "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}

