package com.proj.olxshopv1.Controller;

import com.proj.olxshopv1.DTO.Request.CommentRequest;
import com.proj.olxshopv1.DTO.Response.CommentResponse;
import com.proj.olxshopv1.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentResponse> getAllComments(){
        return commentService.getAllComments();
    }
    @GetMapping("/{id}")
    public List<CommentResponse> getAllCommentsOfCommodityById(@PathVariable Long id){
        return commentService.getAllCommentsOfCommodityById(id);
    }
    @PostMapping
    public void save(@RequestBody CommentRequest commentRequest){
        commentService.save(commentRequest);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){commentService.delete(id);}
    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody CommentRequest commentRequest){
        commentService.update(id,commentRequest);
    }
}
