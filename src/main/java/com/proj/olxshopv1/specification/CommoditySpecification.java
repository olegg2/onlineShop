package com.proj.olxshopv1.specification;

import com.proj.olxshopv1.DTO.Request.filter.FilterCommodityRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterCommodityRequestList;
import com.proj.olxshopv1.Entity.CommodityEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CommoditySpecification implements Specification<CommodityEntity> {

    private FilterCommodityRequestList filterCommodityRequestList;

    public CommoditySpecification(FilterCommodityRequestList filterCommodityRequestList){
        this.filterCommodityRequestList=filterCommodityRequestList;
    }
    //////////////////////////////////////////////////
    private Predicate filterByDeveloper(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                        FilterCommodityRequest filterCommodityRequest){
        return criteriaBuilder.like(root.get("developer").get("developerTitle"),"%"+filterCommodityRequest.getFirstValue()+"%");

    }
    private Predicate filterByCommodityTitle(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                             FilterCommodityRequest filterCommodityRequest){
        return criteriaBuilder.like(root.get("commodityTitle"),"%"+filterCommodityRequest.getFirstValue()+"%");
    }
    private Predicate filterByPrice(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                             FilterCommodityRequest filterCommodityRequest) {
        if(filterCommodityRequest.getFirstValue()!=null && filterCommodityRequest.getSecondValue()!=null){
            return criteriaBuilder.between(root.get("price"),
                    Integer.parseInt(filterCommodityRequest.getFirstValue()),
                    Integer.parseInt(filterCommodityRequest.getSecondValue()));
        }else{
            return criteriaBuilder.conjunction();
        }
    }
    private Predicate filterByType(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                    FilterCommodityRequest filterCommodityRequest){
        return criteriaBuilder.like(root.get("type").get("typeTitle"),"%"+filterCommodityRequest.getFirstValue()+"%");

    }
    private Predicate filterBySort(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                    FilterCommodityRequest filterCommodityRequest){
        return criteriaBuilder.like(root.get("sort").get("sortTitle"),"%"+filterCommodityRequest.getFirstValue()+"%");

    }

    private Predicate filterByState(Root<CommodityEntity> root, CriteriaBuilder criteriaBuilder,
                                   FilterCommodityRequest filterCommodityRequest){
        return criteriaBuilder.like(root.get("state"),"%"+filterCommodityRequest.getFirstValue()+"%");
    }
/////////////////////////////////////////////////////


    private Predicate createFilter(Root<CommodityEntity> root,CriteriaBuilder criteriaBuilder){
        List<Predicate> predicates = new ArrayList<>();
        filterCommodityRequestList.getFilterCommodityRequests().forEach(filterCommodityRequest -> {
            switch (filterCommodityRequest.getCriteriaForSearchCommodity()){
                case BY_TITLE_LIKE:{
                    predicates.add(filterByCommodityTitle(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }
                case BY_DEVELOPER_LIKE:{
                    predicates.add(filterByDeveloper(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }
                case BY_PRICE_BETWEEN:{
                    predicates.add(filterByPrice(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }
                case BY_TYPE_LIKE:{
                    predicates.add(filterByType(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }
                case BY_SORT_LIKE:{
                    predicates.add(filterBySort(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }
                case BY_STATE_LIKE:{
                    predicates.add(filterByState(root,criteriaBuilder,filterCommodityRequest));
                    break;
                }

            }


        });
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }




    @Override
    public Predicate toPredicate(Root<CommodityEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return createFilter(root, criteriaBuilder);
    }
}
