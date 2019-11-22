package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeveloperRequest {
    private String developerTitle;

    public DeveloperRequest(String developerTitle) {
        this.developerTitle = developerTitle;
    }
    public DeveloperRequest(){}
}
