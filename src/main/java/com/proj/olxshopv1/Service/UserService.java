package com.proj.olxshopv1.Service;

import com.proj.olxshopv1.DTO.Request.UserRequest;
import com.proj.olxshopv1.DTO.Response.UserResponse;
import com.proj.olxshopv1.Entity.CommodityEntity;
import com.proj.olxshopv1.Entity.UserEntity;
import com.proj.olxshopv1.Exception.WrongInputDataException;
import com.proj.olxshopv1.Repository.CommodityRepository;
import com.proj.olxshopv1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommodityRepository commodityRepository;

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream()
                .map(UserResponse::new).collect(Collectors.toList());
    }
    public UserResponse getUserById(Long id){
        return new UserResponse(userRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("User is not found by id = "+id)));
    }
    public void save(UserRequest userRequest){
        UserEntity userEntity = new UserEntity(userRequest);
        userRepository.save(userEntity);
    }
    ////////////////////
    public Long singIn(UserRequest userRequest){
        UserEntity userEntity;
        try {
            userEntity =userRepository.findFirstByNameAndPasswordLike(
                    userRequest.getName(),userRequest.getPassword());
        }catch (Exception e){
            throw new WrongInputDataException("there are no such user");
        }

        System.out.println("picked UserEntity = name:"+userEntity.getName()+" password:"+userEntity.getPassword());
        return userEntity.getId();
    }
    ////////////////////
    public void delete(Long id){
        UserEntity userEntity =userRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));
        if(userEntity.getUserShop().isEmpty()){
            userRepository.delete(userEntity);
        }else{
            throw new WrongInputDataException("Type with id="+id+" has a mistake");
        }
    }

    public void deleteFromBasket(Long userId,Long commodityId){
        UserEntity userEntity =userRepository.findById(userId)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+userId));

       CommodityEntity commodityEntity= commodityRepository.findById(commodityId)
               .orElseThrow(()->new WrongInputDataException("Can't find commodity"));
        userEntity.getUserBasket().remove(commodityEntity);
        userRepository.save(userEntity);
    }
    public void update(Long id,UserRequest userRequest){
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id="+id));
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setName(userRequest.getName());
        userEntity.setPassword(userRequest.getPassword());

        userRepository.save(userEntity);
    }
    public void addCommodityToBasket(Long userId,Long commodityId){
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()->new WrongInputDataException("Can't find User by this id = "+userId));
        userEntity.getUserBasket().add(commodityRepository.findById(commodityId).orElseThrow(
                ()->new WrongInputDataException("Can't find commodity by this id = "+commodityId)
        ));


        userRepository.save(userEntity);

    }
}
