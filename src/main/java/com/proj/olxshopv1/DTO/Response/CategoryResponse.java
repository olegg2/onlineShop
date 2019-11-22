package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class CategoryResponse {
    private String categoryTitle;
    private Long id;

    private List<TypeResponse> types;

    public CategoryResponse(CategoryEntity categoryEntity) {
        this.categoryTitle = categoryEntity.getCategoryTitle();
        this.id = categoryEntity.getId();
        this.types = categoryEntity.getCategoryTypes().stream()
        .map(TypeResponse::new).collect(Collectors.toList());
    }
}
