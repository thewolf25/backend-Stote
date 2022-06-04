package org.ecommerce.dto;

import lombok.Data;
import org.ecommerce.entities.Product;

import java.util.List;


@Data
public class SaleRequest {

    private String name;
    private String address;
    private String email;
    private List<ProductDto> products;
}
