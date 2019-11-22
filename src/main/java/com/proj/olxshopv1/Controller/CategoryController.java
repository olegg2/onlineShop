package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.CategoryRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterCategoryRequest;
import com.proj.olxshopv1.DTO.Response.CategoryResponse;
import com.proj.olxshopv1.DTO.Response.TypeResponse;
import com.proj.olxshopv1.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
    ///////
    @PostMapping("/filter")
    public List<CategoryResponse> filter(@RequestBody FilterCategoryRequest filterCategoryRequest){
        return categoryService.getAllFilteredCategories(filterCategoryRequest);
    }
    ///////
    @PostMapping
    public void save (@RequestBody CategoryRequest categoryRequest){
        categoryService.save(categoryRequest);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody CategoryRequest categoryRequest){
        categoryService.update(id,categoryRequest);
    }
    @DeleteMapping
    public void delete (@RequestParam Long id){
        categoryService.delete(id);
    }

}
