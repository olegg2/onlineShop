package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.DescriptionRequest;
import com.proj.olxshopv1.DTO.Response.DescriptionResponse;
import com.proj.olxshopv1.Service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/description")
public class DescriptionController {
    @Autowired
    DescriptionService descriptionService;

    @GetMapping
    public List<DescriptionResponse> getAllDescriptions(){
        return descriptionService.getAllDescriptions();
    }
    @GetMapping("/{id}")
    public DescriptionResponse getDescriptionById(@PathVariable Long id){
        return descriptionService.getDescriptionById(id);
    }
    @PostMapping
    public void save(@RequestBody DescriptionRequest descriptionRequest){
        descriptionService.save(descriptionRequest);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){
        descriptionService.delete(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody DescriptionRequest descriptionRequest){
        descriptionService.update(id,descriptionRequest);
    }
}
