package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.DeveloperRequest;
import com.proj.olxshopv1.DTO.Response.DeveloperResponse;
import com.proj.olxshopv1.Entity.DeveloperEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperService {
    @Autowired
    private DeveloperRepository developerRepository;

    public List<DeveloperResponse> getAllDevelopers(){
        return developerRepository.findAllByOrderByDeveloperTitle()
                .stream().map(DeveloperResponse::new).collect(Collectors.toList());
    }
    public DeveloperResponse getDeveloperById(Long id){
        return new DeveloperResponse(developerRepository.findById(id).orElseThrow(()->
                new WrongInputDataException("Can't find developer by this id = "+id)));
    }
    /////

    public List<DeveloperResponse> getAllFilteredDevelopers(String filterRequest){
        return developerRepository.findAllByDeveloperTitleLike("%"+filterRequest+"%")
                .stream().map(DeveloperResponse::new).collect(Collectors.toList());
    }
    /////
    public void save(DeveloperRequest developerRequest){
        DeveloperEntity developerEntity = new DeveloperEntity(developerRequest.getDeveloperTitle());
        developerRepository.save(developerEntity);
    }
    public void delete(Long id){
        DeveloperEntity developerEntity = developerRepository.findById(id).orElseThrow(()->
                new WrongInputDataException("Can't find developer by this id = "+id));
        if(developerEntity.getCommodities().isEmpty())
            developerRepository.delete(developerEntity);
        else throw new WrongInputDataException("Developer mistake");
    }
    public void update(Long id,DeveloperRequest developerRequest){
        DeveloperEntity developerEntity = developerRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));
        developerEntity.setDeveloperTitle(developerRequest.getDeveloperTitle());
        developerRepository.save(developerEntity);
    }
}
