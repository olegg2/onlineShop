package com.proj.olxshopv1.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class TypeEntity extends IdEntity{
    private String typeTitle;

    @OneToMany(mappedBy = "type")
    private List<CommodityEntity> commodities;
    @ManyToOne
    private CategoryEntity category;

    public TypeEntity(String typeTitle,CategoryEntity category) {
        this.typeTitle = typeTitle;
        this.category=category;
    }
    public TypeEntity(String typeTitle) {
        this.typeTitle = typeTitle;
    }
    public TypeEntity(){}
}
