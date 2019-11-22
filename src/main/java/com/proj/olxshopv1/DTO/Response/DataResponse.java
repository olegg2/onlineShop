package com.proj.olxshopv1.DTO.Response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class DataResponse<T> {
    private List<T> data;

    private Integer page;

    private Integer size;

    private Long totalElements;

    public DataResponse(List<T> data, Page page){
        this.data=data;
        this.size=page.getSize();
        this.page=page.getNumber();
        this.totalElements=page.getTotalElements();
    }
}
