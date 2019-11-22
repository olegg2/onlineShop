package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    private String name;
    private String password;
    private String email;


    public UserRequest(){}
}
