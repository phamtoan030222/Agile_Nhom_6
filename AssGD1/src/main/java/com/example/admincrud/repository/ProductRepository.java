package com.example.admincrud.repository;
import com.example.admincrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long>{}
