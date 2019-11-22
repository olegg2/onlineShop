package com.proj.olxshopv1.DTO.Request.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class FilterCommodityRequestList {
    List<FilterCommodityRequest> filterCommodityRequests = new ArrayList<>();
}
