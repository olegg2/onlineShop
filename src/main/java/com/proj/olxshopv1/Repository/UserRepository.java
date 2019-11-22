package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findFirstByNameAndPasswordLike(String name,String password);
}
