package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.DescriptionRequest;
import com.proj.olxshopv1.DTO.Response.DescriptionResponse;
import com.proj.olxshopv1.Entity.DescriptionEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.DescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DescriptionService {
    @Autowired
    DescriptionRepository descriptionRepository;

    public List<DescriptionResponse> getAllDescriptions(){
        return descriptionRepository.findAll()
                .stream().map(DescriptionResponse::new).collect(Collectors.toList());
    }
    public DescriptionResponse getDescriptionById(Long id){
        return new DescriptionResponse(descriptionRepository.findById(id)
        .orElseThrow(()->new WrongInputDataException("there is no such description by this id = "+id)));

    }
    public void save(DescriptionRequest descriptionRequest){
       DescriptionEntity descriptionEntity= new DescriptionEntity(descriptionRequest.getDescriptionContent());
       descriptionRepository.save(descriptionEntity);
    }
    public void delete(Long id){
        DescriptionEntity descriptionEntity =descriptionRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("there is no such description by this id = "+id));
        descriptionRepository.delete(descriptionEntity);
    }
    public void update(Long id,DescriptionRequest descriptionRequest){
        DescriptionEntity descriptionEntity = descriptionRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));
        descriptionEntity.setDescriptionContent(descriptionRequest.getDescriptionContent());
       descriptionRepository.save(descriptionEntity);
    }
}
