package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.DeveloperRequest;
import com.proj.olxshopv1.DTO.Response.DeveloperResponse;
import com.proj.olxshopv1.Entity.DeveloperEntity;
import com.proj.olxshopv1.Service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @GetMapping
    public List<DeveloperResponse> getAllDevelopers(){
        return developerService.getAllDevelopers();
    }
    @GetMapping("/{id}")
    public DeveloperResponse getDeveloperById(@PathVariable Long id){
        return developerService.getDeveloperById(id);
    }
    /////
    @PostMapping("/filter")
    public List<DeveloperResponse> filter(@RequestBody String filterRequest){
        return developerService.getAllFilteredDevelopers(filterRequest);
    }
    /////
    @PostMapping
    public void save(@RequestBody DeveloperRequest developerRequest){
         developerService.save(developerRequest);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){
        developerService.delete(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody DeveloperRequest developerRequest){
        developerService.update(id,developerRequest);
    }
}
