package com.proj.olxshopv1.Entity;

import com.proj.olxshopv1.DTO.Request.CommodityRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class CommodityEntity extends IdEntity {

    public CommodityEntity(){}
    //spring data jpa - надає частину функціоналу(крат методи)
    //http protocol
    //http requests post put delete get
    //pojo
    //servlet
    //dao
    public CommodityEntity(CommodityRequest commodityRequest){
        this.commodityTitle =commodityRequest.getCommodityTitle();
        this.idOfCommodity = commodityRequest.getIdOfCommodity();
        this.picture = commodityRequest.getPicture();
        this.dateOfAdding =commodityRequest.getDateOfAdding();
        this.state = commodityRequest.getState();
        this.price = commodityRequest.getPrice();
        this.inStock = commodityRequest.getInStock();
        this.sort=commodityRequest.getSort();
        this.type=commodityRequest.getType();
        this.description = commodityRequest.getDescription();
        this.developer = commodityRequest.getDeveloper();
        this.location = commodityRequest.getLocation();
        this.userSeller=commodityRequest.getUserSeller();


    }

    public CommodityEntity(String commodityTitle, int idOfCommodity, String picture,
                           String dateOfAdding, String state,int price,int inStock, DescriptionEntity description,
                            DeveloperEntity developer,
                           LocationEntity location, SortEntity sort, TypeEntity type,UserEntity userSeller) {
        this.commodityTitle = commodityTitle;
        this.idOfCommodity = idOfCommodity;
        this.picture = picture;
        this.dateOfAdding = dateOfAdding;
        this.state = state;
        this.description = description;
        //this.comments = comments;
        this.developer = developer;
        this.location = location;
        this.sort = sort;
        this.type = type;
        this.price=price;
        this.inStock=inStock;
        this.userSeller=userSeller;

    }

    private String commodityTitle;
    private int idOfCommodity;
    private String picture;
    private String dateOfAdding;
    private String state;
    private int price;
    private int inStock;
    @ManyToOne
    //@JoinColumn(name = "description")
    private DescriptionEntity description;
    @OneToMany(mappedBy = "commodity")
    private List<CommentEntity> comments;
    @ManyToOne
    private DeveloperEntity developer;
    @ManyToOne
    private LocationEntity location;
    @ManyToOne
    private SortEntity sort;
    @ManyToOne
    private TypeEntity type;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "userBasket")
    private List<UserEntity> userBuyers;
    @ManyToOne
    private UserEntity userSeller;
}
