package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() { return repository.findAll(); }
    public Optional<Category> findById(Long id) { return repository.findById(id); }
    public Category save(Category c) { return repository.save(c); }
    public void deleteById(Long id) { repository.deleteById(id); }
}
