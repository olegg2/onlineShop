package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.LocationRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterLocationRequest;
import com.proj.olxshopv1.DTO.Response.LocationResponse;
import com.proj.olxshopv1.Entity.LocationEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.LocationRepository;
import com.proj.olxshopv1.specification.LocationSpecification;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<LocationResponse> getAllLocations(){
        return locationRepository.findAllByOrderByTitleOfCity().stream()
                .map(LocationResponse::new).collect(Collectors.toList());
    }

    public List<LocationResponse> getAllLocationsOrderByTitleOfStreet(){
        return locationRepository.findAllByOrderByTitleOfStreet().stream()
                .map(LocationResponse::new).collect(Collectors.toList());
    }
    public LocationResponse getLocationById(Long id){
        return new LocationResponse(locationRepository
        .findById(id).orElseThrow(()->new WrongInputDataException("There is no location of this id = "+id)));

    }
    /////
    public List<LocationResponse> filter(FilterLocationRequest filterLocationRequest){
        LocationSpecification locationSpecification = new LocationSpecification(filterLocationRequest);
        return locationRepository.findAll(locationSpecification)
                .stream().map(LocationResponse::new).collect(Collectors.toList());
    }
    ////
    public List<LocationResponse> getAllFilteredLocationsByCity(String filterRequest){
        return locationRepository.findAllByTitleOfCityLike("%"+filterRequest+"%")
                .stream().map(LocationResponse::new).collect(Collectors.toList());
    }

    public List<LocationResponse> getAllFilteredLocationsByStreet(String filterRequest){
        return locationRepository.findAllByTitleOfStreetLike("%"+filterRequest+"%")
                .stream().map(LocationResponse::new).collect(Collectors.toList());
    }
    /////
    public void save(LocationRequest locationRequest){
        LocationEntity locationEntity = new LocationEntity(locationRequest);
        locationRepository.save(locationEntity);
    }
    public void delete(Long id){
        LocationEntity locationEntity =locationRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find location by this id="+id));
        if(locationEntity.getCommodities().isEmpty()){
            locationRepository.delete(locationEntity);
        }else{
            throw new WrongInputDataException("Location with id="+id+" has a mistake");
        }
    }
    public void update(Long id,LocationRequest locationRequest){
        LocationEntity locationEntity = locationRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));
        locationEntity.setNumberOfFlat(locationRequest.getNumberOfFlat());
        locationEntity.setNumberOfHouse(locationRequest.getNumberOfHouse());
        locationEntity.setTitleOfStreet(locationRequest.getTitleOfStreet());
        locationEntity.setTitleOfCity(locationRequest.getTitleOfCity());
        locationRepository.save(locationEntity);

    }
}
