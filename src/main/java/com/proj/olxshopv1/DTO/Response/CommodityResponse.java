package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.CommodityEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class CommodityResponse {
    private Long id;
    private String commodityTitle;
    private int idOfCommodity;
    private String picture;
    private String dateOfAdding;
    private String state;
    private String description;

    private List<CommentResponse> comments;

    private String developer;

    private LocationResponse location;


    private int price;

    private int inStock;

    private String sort;
    private String type;
    private String category;

    private List<String> userBuyers;
    private String userSeller;
   // private List<UserResponse> userSellers;

    public CommodityResponse(){}
    public CommodityResponse(CommodityEntity commodityEntity) {
        this.id = commodityEntity.getId();
        this.commodityTitle = commodityEntity.getCommodityTitle();
        this.idOfCommodity =commodityEntity.getIdOfCommodity();
        this.picture = commodityEntity.getPicture();
        this.dateOfAdding = commodityEntity.getDateOfAdding();
        this.state = commodityEntity.getState();
        this.price = commodityEntity.getPrice();
        this.inStock = commodityEntity.getInStock();
        this.sort = commodityEntity.getSort().getSortTitle();
        this.type = commodityEntity.getType().getTypeTitle();
        this.category = commodityEntity.getType().getCategory().getCategoryTitle();
        this.description = commodityEntity.getDescription().getDescriptionContent();

        this.comments = commodityEntity.getComments().stream().map(CommentResponse::new).collect(Collectors.toList());

        this.developer = commodityEntity.getDeveloper().getDeveloperTitle();
        this.location = new LocationResponse();
        this.location.setNumberOfFlat(commodityEntity.getLocation().getNumberOfFlat());
        this.location.setNumberOfHouse(commodityEntity.getLocation().getNumberOfHouse());
        this.location.setTitleOfCity(commodityEntity.getLocation().getTitleOfCity());
        this.location.setTitleOfStreet(commodityEntity.getLocation().getTitleOfStreet());
        userBuyers=new ArrayList<>();
        try {
            for (int i = 0; i < commodityEntity.getUserBuyers().size(); i++) {
                this.userBuyers.add(commodityEntity.getUserBuyers().get(i).getName());
            }
        }catch (Exception e){System.out.println(commodityEntity.getUserBuyers().size());}

        this.userSeller=commodityEntity.getUserSeller().getName();


       /* this.userBuyers = commodityEntity.getUserBuyers()
                .stream().map(UserResponse::new).collect(Collectors.toList());
        this.userSellers = commodityEntity.getUserSellers()
                .stream().map(UserResponse::new).collect(Collectors.toList());*/
    }
}
