package com.poly.server.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    private Long id;

    // Validate o trong tang request.
    // Khong validate trong entity => mapping vs CSDL
    @NotBlank(message = "Category code khong duoc de trong")
    private String categoryCode;

    @NotBlank(message = "Category name khong duoc de trong")
    private String categoryName;

}
