package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.SortEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class SortResponse {
    private Long id;
    private String sortTitle;

    private List<CommodityResponse> commodities;

    public SortResponse(SortEntity sortEntity){
        this.id=sortEntity.getId();
        this.sortTitle=sortEntity.getSortTitle();
        this.commodities=sortEntity.getCommodities()
                .stream().map(CommodityResponse::new)
                .collect(Collectors.toList());
    }
}
