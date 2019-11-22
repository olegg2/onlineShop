package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.SortRequest;
import com.proj.olxshopv1.DTO.Response.SortResponse;
import com.proj.olxshopv1.Entity.SortEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.SortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortService {
    @Autowired
    SortRepository sortRepository;

    public List<SortResponse> getAllSorts(){
        return sortRepository.findAllByOrderBySortTitle()
                .stream().map(SortResponse::new).collect(Collectors.toList());

    }
    public SortResponse getSortById(Long id){
        return new SortResponse(sortRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Sort by this id = "+id)));
    }
    /////
    public List<SortResponse> getAllFilteredTypes(String filterTypeRequest){
        return sortRepository.findAllBySortTitleLike("%"+filterTypeRequest+"%")
                .stream().map(SortResponse::new).collect(Collectors.toList());
    }
    /////
    public void save(SortRequest sortRequest){
            SortEntity sortEntity;
            sortEntity = new SortEntity(sortRequest.getSortTitle());
            sortRepository.save(sortEntity);
       }

    public void delete(Long id){
        SortEntity sortEntity= sortRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Sort by this id = "+id));

        if(sortEntity.getCommodities().isEmpty()){
            sortRepository.delete(sortEntity);
        }else {
            throw new WrongInputDataException("Brand with id "+id+"  has a mistake");
        }
    }

    public void update(Long id, SortRequest sortRequest) {
        SortEntity sortEntity= sortRepository.findById(id).orElseThrow
                (()->new WrongInputDataException("Brand with id="+id+" not found"));
        sortEntity.setSortTitle(sortRequest.getSortTitle());
        sortRepository.save(sortEntity);

    }




}
