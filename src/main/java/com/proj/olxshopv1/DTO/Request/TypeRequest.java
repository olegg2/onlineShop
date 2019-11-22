package com.proj.olxshopv1.DTO.Request;

import com.proj.olxshopv1.Entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeRequest {
    private String typeTitle;
    private CategoryEntity categoryId;

    public TypeRequest(String typeTitle,CategoryEntity categoryId) {
        this.categoryId=categoryId;
        this.typeTitle = typeTitle;
    }

    public TypeRequest() {
    }
}
