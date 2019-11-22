package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.DeveloperEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class DeveloperResponse {
    private String developerTitle;
    private Long id;
    private List<CommodityResponse> commoditiesResponse;

    public DeveloperResponse(DeveloperEntity developerEntity){
        developerTitle=developerEntity.getDeveloperTitle();
        this.id  = developerEntity.getId();
        commoditiesResponse=developerEntity.getCommodities()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());
    }



}
