package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.expection.ApiException1;
import com.poly.server.model.request.CategoryRequest;
import com.poly.server.model.response.CategoryResponse;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository cateRepository;

    public List<CategoryResponse> getAll() {
        // cateRepository.findAll()
        return cateRepository.findAll()
                .stream()
                // mapping toan bo entiy(Category)-> response
                .map(CategoryResponse::new)
                .toList();
    }

    public CategoryResponse getOne(Long id) {
        return new CategoryResponse(cateRepository.findById(id).get());
    }

    public void addCategory(CategoryRequest request) {
        // B1: chuyen tu request -> entity
        Category cate = MapperUtil.map(request, Category.class);
        // B2: add
        cateRepository.save(cate);
    }

    public void updateCategory(CategoryRequest request, Long id) {
        // B1: Mapping tu request ve entity
        MapperUtil.mapToExisting(request, Category.class);
        Category cateExist = cateRepository.findById(id).get();
        MapperUtil.mapToExisting(request, cateExist);
        // Boi vi sau mapping id se chuyen ve null theo id cua request nen can set lai
        cateExist.setId(id);
        cateRepository.save(cateExist);
    }

    public void delete(Long id) {
        // check ngoai le xem id ton tai chua ? Hom sau huong dan
        cateRepository.findById(id).orElseThrow(
                () -> new ApiException1("Id khong ton tai", "C01"));
        cateRepository.deleteById(id);
    }

    public Page<CategoryResponse> phanTrang(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Category> pageProduct = cateRepository.findAll(pageable);
        // map tu Product => Product Response
        Page<CategoryResponse> pageResponse = pageProduct.map(CategoryResponse::new);
        return pageResponse;
    }

}
