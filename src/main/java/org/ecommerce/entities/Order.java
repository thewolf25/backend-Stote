package org.ecommerce.entities;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private double ttc;
    private double tax = 0.06;
    private double _shippingCost = 7;
    private LocalDateTime dateCommande;
    private User client;
    @OneToMany
    private List<OrderDetails> orderDetails;



}
