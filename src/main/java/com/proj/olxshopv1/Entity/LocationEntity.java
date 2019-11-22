package com.proj.olxshopv1.Entity;

import com.proj.olxshopv1.DTO.Request.LocationRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
public class LocationEntity extends IdEntity {//+
    private String titleOfCity;
    private String titleOfStreet;
    private int numberOfHouse;
    private int numberOfFlat;

    @OneToMany(mappedBy = "location")
    private List<CommodityEntity> commodities;

    public LocationEntity(String titleOfCity, String titleOfStreet, int numberOfHouse, int numberOfFlat) {
        this.titleOfCity = titleOfCity;
        this.titleOfStreet = titleOfStreet;
        this.numberOfHouse = numberOfHouse;
        this.numberOfFlat = numberOfFlat;
    }
    public LocationEntity(LocationRequest locationRequest){
        this.titleOfCity = locationRequest.getTitleOfCity();
        this.titleOfStreet = locationRequest.getTitleOfStreet();
        this.numberOfHouse = locationRequest.getNumberOfHouse();
        this.numberOfFlat = locationRequest.getNumberOfFlat();
    }
    public LocationEntity(){}
}
