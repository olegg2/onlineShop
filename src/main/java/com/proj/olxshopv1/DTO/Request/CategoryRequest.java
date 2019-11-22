package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    private String categoryTitle;

    public CategoryRequest(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
    public CategoryRequest(){}
}
