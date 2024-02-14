package com.monlau.springbootdemo01.repository;
import com.monlau.springbootdemo01.model.products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<products, Integer> {
}
