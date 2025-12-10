package com.poly.server.controller;

import com.poly.server.model.request.CategoryRequest;
import com.poly.server.model.response.CategoryResponse;
import com.poly.server.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category-management")
public class CategoryController {

    // Restfull API => GET, POST, PUT, DELETE
    // GET => lay, hien thi => SELECT
    // POST => Add
    // PUT => UPDATE
    // DELETE => DELETE

    // Quy tat dat ten chuan restfull: https://blog.vietnamlab.vn/restful-api-convention/

    @Autowired
    private CategoryService cateService;

    @GetMapping
    public List<CategoryResponse> hienThiDuLieu() {
        return cateService.getAll();
    }

    // C1: Path Variable
    @GetMapping("{id1}")
    public CategoryResponse detailCate(@PathVariable("id1") Long id) {
        return cateService.getOne(id);
    }

    // C2: Request Param
    @GetMapping("detail")
    public CategoryResponse detailCate1(@RequestParam("id2") Long id) {
        return cateService.getOne(id);
    }

    @PostMapping("add")
    // @RequestBody <=> @ModelAttribute
    public void addCate(@Valid @RequestBody CategoryRequest request) {
        cateService.addCategory(request);
    }

    @PutMapping("update/{id}")
    public void updateCate(@Valid @RequestBody CategoryRequest request, @PathVariable("id") Long id) {
        cateService.updateCategory(request, id);
    }

    @DeleteMapping("delete")
    public void deleteCate(@RequestParam("id") Long id) {
        cateService.delete(id);
    }

    @GetMapping("paging")
    public List<CategoryResponse> phanTrang(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return cateService.phanTrang(pageNo, pageSize).getContent();
    }
}
