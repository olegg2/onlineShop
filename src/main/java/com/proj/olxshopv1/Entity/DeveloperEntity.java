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
public class DeveloperEntity extends IdEntity {//+
    private String developerTitle;
    @OneToMany(mappedBy = "developer")
    private List<CommodityEntity> commodities;

    public DeveloperEntity(String developerTitle) {
        this.developerTitle = developerTitle;
    }
    public DeveloperEntity(){}
}
