package com.proj.olxshopv1.DTO.Request;

import com.proj.olxshopv1.Entity.CommodityEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    String commentContent;
    String userName;
    private CommodityEntity commodity;

    public CommentRequest(String commentContent) {
        this.commentContent = commentContent;
        //commodity=
    }
    public CommentRequest(){}
}
