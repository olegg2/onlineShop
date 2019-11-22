package com.proj.olxshopv1.specification;

import com.proj.olxshopv1.DTO.Request.filter.FilterLocationRequest;
import com.proj.olxshopv1.Entity.LocationEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LocationSpecification implements Specification<LocationEntity> {
    private FilterLocationRequest filterLocationRequest;

    public LocationSpecification(FilterLocationRequest filterLocationRequest) {
        this.filterLocationRequest = filterLocationRequest;
    }

    private Predicate filterByNumberOfHouse(Root<LocationEntity> root, CriteriaBuilder criteriaBuilder) {
        if (filterLocationRequest.getNumberOfHouseFrom() != 0 && filterLocationRequest.getNumberOfHouseTo() != 0) {
            return criteriaBuilder.between(root.get("numberOfHouse"),
                    filterLocationRequest.getNumberOfHouseFrom(), filterLocationRequest.getNumberOfHouseTo());
        } else {
            return criteriaBuilder.conjunction();
        }
    }

    private Predicate filterByNumberOfFlat(Root<LocationEntity> root, CriteriaBuilder criteriaBuilder) {
        if (filterLocationRequest.getNumberOfFlatFrom() != 0 && filterLocationRequest.getNumberOfFlatTo() != 0) {
            return criteriaBuilder.between(root.get("numberOfFlat"),
                    filterLocationRequest.getNumberOfFlatFrom(), filterLocationRequest.getNumberOfFlatTo());
        } else return criteriaBuilder.conjunction();
    }

    private Predicate filterByTitleOfCity(Root<LocationEntity> root, CriteriaBuilder criteriaBuilder) {
        if (filterLocationRequest.getTitleOfCity() != null) {
            return criteriaBuilder.like(root.get("titleOfCity"), "%"+filterLocationRequest.getTitleOfCity()+"%");
        } else return criteriaBuilder.conjunction();
    }

    private Predicate filterByTitleOfStreet(Root<LocationEntity> root, CriteriaBuilder criteriaBuilder) {
        if (filterLocationRequest.getTitleOfStreet() != null) {
            return criteriaBuilder.like(root.get("titleOfStreet"),"%"+filterLocationRequest.getTitleOfStreet()+"%");
        } else return criteriaBuilder.conjunction();
    }


    @Override
    public Predicate toPredicate(Root<LocationEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(filterByNumberOfFlat(root, criteriaBuilder),
                filterByNumberOfHouse(root, criteriaBuilder),
                filterByTitleOfCity(root, criteriaBuilder),
                filterByTitleOfStreet(root, criteriaBuilder));
    }
}
