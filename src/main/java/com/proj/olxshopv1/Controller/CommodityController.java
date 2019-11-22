package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.CommodityRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterCommodityRequestList;
import com.proj.olxshopv1.DTO.Response.CommodityResponse;
import com.proj.olxshopv1.DTO.Response.DataResponse;
import com.proj.olxshopv1.Service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public List<CommodityResponse> getAllCommodities(){return commodityService.getAllCommodity();}
    @GetMapping("/{id}")
    public CommodityResponse getCommodityById(@PathVariable Long id){return  commodityService.getCommodityById(id);}
    @GetMapping("/page")
    public DataResponse<CommodityResponse> getAllCommodityOnPage(
            @RequestParam Integer page, @RequestParam Integer size,
            @RequestParam String sortBy, @RequestParam Sort.Direction direction){
        return commodityService.getAllCommodityOnPage(page,size,sortBy,direction);
    }
    @GetMapping("/filter")
    public DataResponse<CommodityResponse> getAllCommodityByTitleOnPage(
            @RequestParam Integer page, @RequestParam Integer size,
            @RequestParam String sortBy, @RequestParam Sort.Direction direction,
            @RequestParam String name){
        return commodityService.getAllCommodityByTitleOnPage(page,size,sortBy,direction,name);
      //  return commodityService.getAllCommodityOnPage(page,size,sortBy,direction);
    }
    ///////////////////////
    @PostMapping("/filterByAll")
    public List<CommodityResponse> filterByAll(@RequestBody FilterCommodityRequestList filterCommodityRequestList){
        return commodityService.filter(filterCommodityRequestList);
    }

    ///////////////////////

    @GetMapping("/getAllCommodityByType")
    public List<CommodityResponse> getAllCommodityByType(@RequestParam Long id){return  commodityService.getAllCommodityByType(id);}

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CommodityRequest commodityRequest){
        
        commodityService.save(commodityRequest);
        return new ResponseEntity<Void> (HttpStatus.CREATED);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){commodityService.delete(id);}
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody CommodityRequest commodityRequest){
        commodityService.update(id,commodityRequest);
    }
}
