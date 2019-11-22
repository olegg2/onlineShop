package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
    List<CommentEntity> findAllByOrderByCommentContent();
}
