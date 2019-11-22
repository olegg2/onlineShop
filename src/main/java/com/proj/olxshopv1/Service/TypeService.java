package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.TypeRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterTypeRequest;
import com.proj.olxshopv1.DTO.Response.TypeResponse;
import com.proj.olxshopv1.Entity.TypeEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<TypeResponse> getAllTypes(){
        return typeRepository.findAllByOrderByTypeTitle().stream()
                .map(TypeResponse::new).collect(Collectors.toList());
    }
    public TypeResponse getTypeById(Long id){
        return new TypeResponse(typeRepository.findById(id)
        .orElseThrow(()->new WrongInputDataException("Can't find Type by this id="+id)));
    }
    /////
    public List<TypeResponse> getAllFilteredTypes(FilterTypeRequest filterTypeRequest){
        return typeRepository.findAllByTypeTitleLike("%"+filterTypeRequest.getInscription()+"%")
                .stream().map(TypeResponse::new).collect(Collectors.toList());
    }
    /////
    public void save(TypeRequest typeRequest){
        TypeEntity typeEntity=new TypeEntity(typeRequest.getTypeTitle(),typeRequest.getCategoryId());
        typeRepository.save(typeEntity);
    }
    public void delete(Long id){
        TypeEntity typeEntity =typeRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Type by this id="+id));
        if(typeEntity.getCommodities().isEmpty()){
            typeRepository.delete(typeEntity);
        }else{
            throw new WrongInputDataException("Type with id="+id+" has a mistake");
        }
    }
    public void update(Long id,TypeRequest typeRequest){
        TypeEntity typeEntity = typeRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Type by this id="+id));
        typeEntity.setTypeTitle(typeRequest.getTypeTitle());
        typeRepository.save(typeEntity);
    }
}
