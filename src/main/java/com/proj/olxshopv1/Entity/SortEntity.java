package com.proj.olxshopv1.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class SortEntity extends IdEntity {
    private String sortTitle;
    @OneToMany(mappedBy = "sort")
    private List<CommodityEntity> commodities;

    public SortEntity(String sortTitle) {
        this.sortTitle = sortTitle;
    }
    public SortEntity(){}
}
