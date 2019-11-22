package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.CommentRequest;
import com.proj.olxshopv1.DTO.Response.CommentResponse;
import com.proj.olxshopv1.Entity.CommentEntity;
import com.proj.olxshopv1.Entity.CommodityEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.CommentRepository;
import com.proj.olxshopv1.Repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommodityRepository commodityRepository;

    public List<CommentResponse> getAllComments(){
        return commentRepository.findAll()
                .stream().map(CommentResponse::new).collect(Collectors.toList());
    }
    public List<CommentResponse> getAllCommentsOfCommodityById(Long id){
       CommodityEntity commodityEntity= commodityRepository.findById(id).
        orElseThrow(()->new WrongInputDataException("There is no such commodity by this id = "+id));
        return commodityEntity.getComments().stream().map(CommentResponse::new).collect(Collectors.toList());

    }
    public void save(CommentRequest commentRequest){
        CommentEntity commentEntity = new CommentEntity(commentRequest);
        commentRepository.save(commentEntity);
    }

    public void delete(Long id){
        CommentEntity commentEntity=commentRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("There is no comment by this id = "+id));
        commentRepository.delete(commentEntity);
    }
    public void update(Long id, CommentRequest commentRequest){
        CommentEntity commentEntity=commentRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("There is no comment by this id = "+id));
        commentEntity.setCommentContent(commentRequest.getCommentContent());
        commentRepository.save(commentEntity);
    }
}
