package com.proj.olxshopv1.DTO.Request.filter;

import com.proj.olxshopv1.DTO.Request.criteria.CriteriaForSearchCommodity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterCommodityRequest {

    private CriteriaForSearchCommodity criteriaForSearchCommodity;

    private String firstValue;

    private String SecondValue;
}
