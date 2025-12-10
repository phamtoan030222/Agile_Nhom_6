package com.poly.server.model.response;

import com.poly.server.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    // Liet ke cac thuoc tinh tra ve
    private Long id;

    private String categoryCode;

    private String categoryName;


    // Mapping tu entity -> response
    public CategoryResponse(Category cate) {
        this.id = cate.getId();
        this.categoryName = cate.getCategoryName();
        this.categoryCode = cate.getCategoryCode();
    }

}
