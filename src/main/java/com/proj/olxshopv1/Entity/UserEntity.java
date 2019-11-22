package com.proj.olxshopv1.Entity;

import com.proj.olxshopv1.DTO.Request.UserRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class UserEntity extends IdEntity {
    private String name;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "userBaskets_userBuyers",
            joinColumns = { @JoinColumn(name = "userBasket_id") },
            inverseJoinColumns = { @JoinColumn(name = "userBuyer_id") })
    private List<CommodityEntity> userBasket;

    @OneToMany(mappedBy = "userSeller")
     private List<CommodityEntity> userShop;

    public UserEntity(UserRequest userRequest) {
        this.name =userRequest.getName();
        this.password = userRequest.getPassword();
        this.email = userRequest.getEmail();
    }
    public UserEntity(){}



    /* @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
   */

}
