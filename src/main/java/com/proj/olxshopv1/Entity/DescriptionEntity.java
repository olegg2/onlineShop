package com.proj.olxshopv1.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity

@Getter
@Setter
public class DescriptionEntity extends IdEntity {//+
    private String descriptionContent;
    @OneToMany(mappedBy = "description")
    private List<CommodityEntity> commodities;

    public DescriptionEntity(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }
    public DescriptionEntity(){}
}
