package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.CommodityRequest;
import com.proj.olxshopv1.DTO.Request.filter.FilterCommodityRequestList;
import com.proj.olxshopv1.DTO.Response.CommodityResponse;
import com.proj.olxshopv1.DTO.Response.DataResponse;
import com.proj.olxshopv1.DTO.Response.TypeResponse;
import com.proj.olxshopv1.Entity.CategoryEntity;
import com.proj.olxshopv1.Entity.CommentEntity;
import com.proj.olxshopv1.Entity.CommodityEntity;
import com.proj.olxshopv1.Entity.TypeEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.CategoryRepository;
import com.proj.olxshopv1.Repository.CommentRepository;
import com.proj.olxshopv1.Repository.CommodityRepository;
import com.proj.olxshopv1.Repository.TypeRepository;
import com.proj.olxshopv1.specification.CommoditySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityService {

    @Autowired
    CommodityRepository commodityRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    CategoryRepository categoryRepository;
////////////////////////////////////////////////////////////////////////////////////////
    public List<CommodityResponse> getAllCommodity(){
        return commodityRepository.findAllByOrderByCommodityTitle()
                .stream().map(CommodityResponse::new)
                .collect(Collectors.toList());
    }

///////////////////////////////////

    public DataResponse<CommodityResponse> getAllCommodityOnPage(
            Integer page, Integer size, String sortBy, Sort.Direction direction){
        Sort sort =Sort.by(direction,sortBy);
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        Page<CommodityEntity> pageCommodityEntity;

        pageCommodityEntity=commodityRepository.findAll(pageRequest);
        return new DataResponse<CommodityResponse>(pageCommodityEntity.getContent()
        .stream().map(CommodityResponse::new).collect(Collectors.toList()),pageCommodityEntity);
    }

    public DataResponse<CommodityResponse> getAllCommodityByTitleOnPage(
            Integer page,Integer size,String sortBy,Sort.Direction direction,String name){
        Sort sort=Sort.by(direction,sortBy);
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        Page<CommodityEntity> pageCommodityEntity;

        if(name!=null){
            TypeEntity typeEntity = new TypeEntity();


            pageCommodityEntity = commodityRepository.findAllByCommodityTitleLike("%"+name+"%",pageRequest);
        }else{
            pageCommodityEntity = commodityRepository.findAll(pageRequest);
        }
        return new DataResponse<CommodityResponse>(pageCommodityEntity.getContent()
        .stream().map(CommodityResponse::new).collect(Collectors.toList()),pageCommodityEntity);
    }
////////////////////////////////////////
    public CommodityResponse getCommodityById(Long id){
        return  new CommodityResponse(commodityRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Commodity by this id = "+id)));
    }


    public List<CommodityResponse> getAllCommodityByType(Long id){
        TypeEntity typeEntity=typeRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find Type by this id = "+id));
        return commodityRepository.findAllByType(typeEntity).stream()
                .map(CommodityResponse::new).collect(Collectors.toList());


    }


////////////////////////////////////////////////////////////////////////////////////////////////
public List<CommodityResponse> filter(FilterCommodityRequestList filterCommodityRequestList){
    CommoditySpecification commoditySpecification = new CommoditySpecification(filterCommodityRequestList);
    return commodityRepository.findAll(commoditySpecification).stream().map(CommodityResponse::new).collect(Collectors.toList());
}




///////////////////////////////////
    public void save(CommodityRequest commodityRequest){
        CommodityEntity commodityEntity = new CommodityEntity(commodityRequest);
        //commodityEntity.setComments(new ArrayList<CommentEntity>());
       // commentRepository.save(commodityEntity.getComments())
        commodityRepository.save(commodityEntity);

    }
    public void delete(Long id){
        CommodityEntity commodityEntity = commodityRepository.findById(id).orElseThrow(()->
                new WrongInputDataException("Can't find commodity by this id = "+id));
        if(!commodityEntity.getComments().isEmpty()){
            commentRepository.deleteAll(commodityEntity.getComments());
        }
            commodityRepository.delete(commodityEntity);

    }
    public void update(Long id,CommodityRequest commodityRequest){
        CommodityEntity commodityEntity = commodityRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));

        commodityEntity.setCommodityTitle(commodityRequest.getCommodityTitle());
        commodityEntity.setIdOfCommodity(commodityRequest.getIdOfCommodity());
        commodityEntity.setPicture(commodityRequest.getPicture());
        commodityEntity.setDateOfAdding(commodityRequest.getDateOfAdding());
        commodityEntity.setState(commodityRequest.getState());
        commodityEntity.setDescription(commodityRequest.getDescription());
        commodityEntity.setDeveloper(commodityRequest.getDeveloper());
        commodityEntity.setLocation(commodityRequest.getLocation());
        commodityEntity.setSort(commodityRequest.getSort());
        commodityEntity.setType(commodityRequest.getType());
        commodityRepository.save(commodityEntity);

    }
}
