package com.example.admincrud.repository;
import com.example.admincrud.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VariantRepository extends JpaRepository<ProductVariant, Long>{}
