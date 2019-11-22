package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.CommentEntity;
import com.proj.olxshopv1.Entity.CommodityEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponse {
    String commentContent;
    private Long id;
   // private CommodityResponse commodityResponse;

    public CommentResponse(CommentEntity commentEntity){
       this.id = commentEntity.getId();
        commentContent = commentEntity.getCommentContent();
      //  commodityResponse=new CommodityResponse();
      //  commodityResponse.setCommodityTitle(commentEntity.getCommodity().getCommodityTitle());
      //  commodityResponse.setIdOfCommodity(commentEntity.getCommodity().getIdOfCommodity());

    }
}
