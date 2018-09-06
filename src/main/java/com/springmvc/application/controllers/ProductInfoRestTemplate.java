package com.springmvc.application.controllers;

import com.springmvc.application.helpers.Product;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@RestController
public class ProductInfoRestTemplate {

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/template/products", method = RequestMethod.GET)
    public String getProductsByTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProductsByTemplate(@RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<Product>(product,httpHeaders);      // converts it into json and send it to rest api
        return restTemplate.exchange("http://localhost:8080/products",HttpMethod.POST,httpEntity,String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProductByTemplate(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<Product>(product,httpHeaders);      // converts it into json and send it to rest api
        return restTemplate.exchange("http://localhost:8080/products/"+id,HttpMethod.PUT,httpEntity,String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProductByTemplate(@PathVariable("id") String id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);      // converts it into json and send it to rest api
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/products/"+id,HttpMethod.DELETE,httpEntity,String.class);
        // Can apply parsers above and create a json or any type of response object.
        return responseEntity.toString();
    }
}
