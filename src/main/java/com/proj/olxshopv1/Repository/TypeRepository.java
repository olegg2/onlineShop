package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.TypeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity,Long> {
    List<TypeEntity> findAllByTypeTitleLike(String name, Pageable pageable);
    List<TypeEntity> findAllByTypeTitleLike(String name);
    List<TypeEntity> findAllByOrderByTypeTitle();
}
