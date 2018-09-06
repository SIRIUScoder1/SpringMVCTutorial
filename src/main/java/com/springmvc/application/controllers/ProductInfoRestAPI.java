package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductInfoRestAPI {

   Map<String,Product> productMap = new HashMap<>();

    @PostConstruct
    public void initializeProducts() {
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Cars");

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Television");

        productMap.put(product1.getProductId(),product1);
        productMap.put(product2.getProductId(),product2);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Product> getProducts() {
        return productMap.values();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewProduct(@RequestBody Product product) {
        productMap.put(product.getProductId(), product);
        return new ResponseEntity<>("Product was saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateObject(@PathVariable("id") String id, @RequestBody Product product) {
        productMap.remove(id);
        product.setProductId(id);
        productMap.put(id, product);
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteObject(@PathVariable("id") String id) {
        productMap.remove(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
