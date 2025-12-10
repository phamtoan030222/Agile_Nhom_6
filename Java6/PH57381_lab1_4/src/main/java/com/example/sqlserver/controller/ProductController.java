package com.example.sqlserver.controller;
import com.example.sqlserver.entity.*; import com.example.sqlserver.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/products")
public class ProductController {
 private final ProductRepository repo;
 private final CategoryRepository catRepo;
 public ProductController(ProductRepository r, CategoryRepository c){repo=r;catRepo=c;}
 @GetMapping public List<Product> all(){return repo.findAll();}
 @PostMapping public Product add(@RequestBody Product p){return repo.save(p);}
}
