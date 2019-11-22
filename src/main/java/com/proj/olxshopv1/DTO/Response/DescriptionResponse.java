package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.DescriptionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DescriptionResponse {
    private String descriptionContent;
    private Long id;
    private List<CommodityResponse> commoditiesResponse;

    public DescriptionResponse(DescriptionEntity descriptionEntity){
        descriptionContent=descriptionEntity.getDescriptionContent();
        this.id = descriptionEntity.getId();
        commoditiesResponse=descriptionEntity.getCommodities()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());

    }
}
