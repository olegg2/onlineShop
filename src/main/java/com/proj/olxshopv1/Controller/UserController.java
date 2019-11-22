package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.UserRequest;
import com.proj.olxshopv1.DTO.Response.UserResponse;
import com.proj.olxshopv1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers(){return userService.getAllUsers();}
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id){return userService.getUserById(id);}
    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody UserRequest userRequest){
        userService.save(userRequest);
        return new ResponseEntity<Void> (HttpStatus.OK);
    }

    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody UserRequest userRequest){
        Long id =userService.singIn(userRequest);
        return new ResponseEntity<>  (id,HttpStatus.OK);}


    @PostMapping("/addToBasket")
    public ResponseEntity<Void> addToBasket(@RequestParam Long userId,@RequestParam Long commodityId){
        userService.addCommodityToBasket(userId,commodityId);
        return new ResponseEntity<Void>  (HttpStatus.OK);}


    @DeleteMapping("/deleteFromBasket")
    public ResponseEntity<Void> deleteFromBasket(@RequestParam Long userId,@RequestParam Long commodityId){
        userService.deleteFromBasket(userId,commodityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){userService.delete(id);}


    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody UserRequest userRequest){
        userService.update(id,userRequest);
    }
    @PutMapping
    public void addCommodityToBasket(@RequestParam Long userId,@RequestParam Long commodityId){
        userService.addCommodityToBasket(userId,commodityId);
    }
}
