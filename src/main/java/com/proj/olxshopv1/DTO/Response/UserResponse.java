package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class UserResponse {
    private String name;
    private String password;
    private String email;
    private Long id;

    private List<CommodityResponse> userBasket;

    private List<CommodityResponse> userShop;

    public UserResponse(UserEntity userEntity){
        this.name=userEntity.getName();
        this.password=userEntity.getPassword();
        this.email=userEntity.getEmail();
        this.id = userEntity.getId();
        this.userBasket=userEntity.getUserBasket()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());
        this.userShop=userEntity.getUserShop()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());
    }

}
