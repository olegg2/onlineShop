package com.proj.olxshopv1.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
@Getter
@Setter
@Entity
public class CategoryEntity extends IdEntity {

    private String categoryTitle;
    @OneToMany(mappedBy = "category")
    private List<TypeEntity> categoryTypes;

    public CategoryEntity(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
    public CategoryEntity(){}
}
