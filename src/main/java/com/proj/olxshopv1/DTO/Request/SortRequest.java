package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortRequest {
    private String sortTitle;

    public SortRequest(String sortTitle) {
        this.sortTitle = sortTitle;
    }
    public SortRequest(){}
}
