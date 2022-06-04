package org.ecommerce.controllers;


import org.ecommerce.dto.SaleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ordersController {

    @PostMapping("/command")
    public ResponseEntity<String> commander(@RequestBody SaleRequest order){
        return new ResponseEntity<String>("Command Passed !!!" , HttpStatus.OK);
    }
}
