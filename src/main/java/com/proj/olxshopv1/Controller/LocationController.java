package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.LocationRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterLocationRequest;
import com.proj.olxshopv1.DTO.Response.LocationResponse;
import com.proj.olxshopv1.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping
    public List<LocationResponse> getAllLocations(){return locationService.getAllLocations();}
    @GetMapping("/{id}")
    public LocationResponse getLocationById(@PathVariable Long id){return locationService.getLocationById(id);}
    //////
    @PostMapping("/filterByCity")
    public List<LocationResponse> filterCities(@RequestBody String filterRequest){
        return locationService.getAllFilteredLocationsByCity(filterRequest);
    }
    @PostMapping("/filterByStreet")
    public List<LocationResponse> filterStreets(@RequestBody String filterRequest){
        return locationService.getAllFilteredLocationsByStreet(filterRequest);
    }
    @PostMapping("/filter")
    public List<LocationResponse> filter(@RequestBody FilterLocationRequest filterLocationRequest){
        return locationService.filter(filterLocationRequest);
    }
    //////
    @PostMapping
    public void save(@RequestBody LocationRequest locationRequest){locationService.save(locationRequest);}
    @DeleteMapping("/{id)")
    public void delete(@RequestParam Long id){locationService.delete(id);}
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody LocationRequest locationRequest){
        locationService.update(id,locationRequest);
    }
}
