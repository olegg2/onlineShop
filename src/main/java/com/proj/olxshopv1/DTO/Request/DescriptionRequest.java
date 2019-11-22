package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescriptionRequest {
    private String descriptionContent;

    public DescriptionRequest(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }
    public DescriptionRequest(){}
}
