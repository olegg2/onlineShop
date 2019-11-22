package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.CategoryRequest;
import com.proj.olxshopv1.DTO.Request.TypeRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterCategoryRequest;
import com.proj.olxshopv1.DTO.Response.CategoryResponse;
import com.proj.olxshopv1.DTO.Response.TypeResponse;
import com.proj.olxshopv1.Entity.CategoryEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories(){
        return categoryRepository.findAllByOrderByCategoryTitle().stream()
                .map(CategoryResponse::new).collect(Collectors.toList());
    }
    public CategoryResponse getCategoryById(Long id){
        return new CategoryResponse(categoryRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find category by this id="+id)));
    }
    /////
    public List<CategoryResponse> getAllFilteredCategories(FilterCategoryRequest filterCategoryRequest){
        return categoryRepository.findAllByCategoryTitleLike("%"+filterCategoryRequest.getInscription()+"%")
                .stream().map(CategoryResponse::new).collect(Collectors.toList());
    }
    /////
    public void save(CategoryRequest categoryRequest){
        CategoryEntity categoryEntity=new CategoryEntity(categoryRequest.getCategoryTitle());
        categoryRepository.save(categoryEntity);
    }
    public void delete(Long id){
        CategoryEntity categoryEntity =categoryRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find category by this id="+id));
            categoryRepository.delete(categoryEntity);
        }
    public void update(Long id,CategoryRequest categoryRequest){
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find category by this id="+id));
        categoryEntity.setCategoryTitle(categoryRequest.getCategoryTitle());
        categoryRepository.save(categoryEntity);
    }
}
