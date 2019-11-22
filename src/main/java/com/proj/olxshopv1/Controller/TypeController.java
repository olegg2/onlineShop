package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.TypeRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterTypeRequest;
import com.proj.olxshopv1.DTO.Response.TypeResponse;
import com.proj.olxshopv1.Entity.TypeEntity;
import com.proj.olxshopv1.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping
    public List<TypeResponse> getAllTypes(){
        return typeService.getAllTypes();
    }
    @GetMapping("/{id}")
    public TypeResponse getTypeById(@PathVariable Long id){
        return typeService.getTypeById(id);
    }
///////
    @PostMapping("/filter")
    public List<TypeResponse> filter(@RequestBody FilterTypeRequest filterTypeRequest){
        return typeService.getAllFilteredTypes(filterTypeRequest);
    }
///////
    @PostMapping
    public void save (@RequestBody TypeRequest typeRequest){
        typeService.save(typeRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody TypeRequest typeRequest){
        typeService.update(id,typeRequest);
    }
    @DeleteMapping
    public void delete (@RequestParam Long id){
        typeService.delete(id);
    }

}
