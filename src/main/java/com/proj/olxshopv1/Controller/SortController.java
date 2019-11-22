package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.SortRequest;
import com.proj.olxshopv1.DTO.Response.SortResponse;
import com.proj.olxshopv1.Service.SortService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sort")
public class SortController {
    @Autowired
    private SortService sortService;

    @GetMapping
    public List<SortResponse> getAllSorts(){
        return sortService.getAllSorts();
    }
    @GetMapping("/{id}")
    public SortResponse getSortBtId(@PathVariable Long id){
        return sortService.getSortById(id);
    }
    ///////
    @PostMapping("/filter")
    public List<SortResponse> filter(@RequestBody String filterRequest){
        return sortService.getAllFilteredTypes(filterRequest);
    }
    ///////
    @PostMapping
    public void save (@RequestBody SortRequest sortRequest){
        sortService.save(sortRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody SortRequest sortRequest){
        sortService.update(id,sortRequest);
    }
    @DeleteMapping
    public void delete (@RequestParam Long id){
        sortService.delete(id);
    }
}
