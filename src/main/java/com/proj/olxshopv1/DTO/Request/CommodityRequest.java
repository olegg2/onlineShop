package com.proj.olxshopv1.DTO.Request;

import com.proj.olxshopv1.Entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommodityRequest {
    private String commodityTitle;
    private int idOfCommodity;
    private String picture;
    private String dateOfAdding;
    private String state;
    private int price;
    private int inStock;
    private DescriptionEntity description;

    private DeveloperEntity developer;

    private LocationEntity location;

    private SortEntity sort;

    private TypeEntity type;

    private UserEntity userSeller;

    public CommodityRequest(){}
}
