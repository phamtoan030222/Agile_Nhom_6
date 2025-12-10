package com.example.admincrud.repository;
import com.example.admincrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long>{}
