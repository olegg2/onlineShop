package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>, JpaSpecificationExecutor<CategoryEntity> {
    List<CategoryEntity> findAllByCategoryTitleLike(String categoryTitle);

    List<CategoryEntity> findAllByOrderByCategoryTitle();
}
