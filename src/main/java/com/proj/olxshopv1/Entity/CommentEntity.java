package com.proj.olxshopv1.Entity;

import com.proj.olxshopv1.DTO.Request.CommentRequest;
import com.proj.olxshopv1.DTO.Response.CommentResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class CommentEntity extends IdEntity {
    private String commentContent;
    private String userName;

    @ManyToOne
    private CommodityEntity commodity;

    public CommentEntity(CommentRequest commentRequest) {
        this.commentContent = commentRequest.getCommentContent();
        commodity=commentRequest.getCommodity();
        this.userName=commentRequest.getUserName();
    }
    public CommentEntity(){}
}
