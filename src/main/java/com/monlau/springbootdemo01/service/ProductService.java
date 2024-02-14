package com.monlau.springbootdemo01.service;

import com.monlau.springbootdemo01.model.products;
import com.monlau.springbootdemo01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<products> listProducts(){
        return repository.findAll();
    }

    public void saveProduct(products product){
        repository.save(product);
    }

    public products findProductById(Integer id){
            return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado con ID: " + id));
    }
    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
