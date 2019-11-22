package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity,Long> {
    List<DeveloperEntity> findAllByOrderByDeveloperTitle();
    List<DeveloperEntity> findAllByDeveloperTitleLike(String name);
}
