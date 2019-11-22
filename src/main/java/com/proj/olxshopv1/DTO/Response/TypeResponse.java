package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.TypeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class TypeResponse {
    private String typeTitle;
    private String categoryTitle;
    private Long id;
    private List<CommodityResponse> commodities;

    public TypeResponse(TypeEntity typeEntity){
        this.typeTitle=typeEntity.getTypeTitle();
        this.id = typeEntity.getId();
        this.categoryTitle= typeEntity.getCategory().getCategoryTitle();
        this.commodities=typeEntity.getCommodities()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());
    }

}
