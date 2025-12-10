package com.example.sqlserver.controller;
import com.example.sqlserver.entity.Category;
import com.example.sqlserver.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController @RequestMapping("/api/categories")
public class CategoryController {
 private final CategoryRepository repo;
 public CategoryController(CategoryRepository r){this.repo=r;}
 @GetMapping public List<Category> all(){return repo.findAll();}
 @PostMapping public Category add(@RequestBody Category c){return repo.save(c);}
}
