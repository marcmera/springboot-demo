package com.monlau.springbootdemo01.controller;

import com.monlau.springbootdemo01.model.products;
import com.monlau.springbootdemo01.service.NotFoundException;
import com.monlau.springbootdemo01.service.ProductService;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<products> listProducts(){
        return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<products> getProduct(@PathVariable Integer id){
        try{
            products product = productService.findProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public void newProduct(@RequestBody products product){
        productService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> editProduct(@RequestBody products product, @PathVariable Integer id){
        try{
            products productDB = productService.findProductById(id);
            productDB.setProduct_name(product.getProduct_name());
            productDB.setPrice(product.getPrice());
            productService.saveProduct(productDB);
            return new ResponseEntity<products>(product,HttpStatus.OK);
        }
        catch (NotFoundException e){
            return new ResponseEntity<products>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

}