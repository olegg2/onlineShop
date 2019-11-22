package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.SortEntity;
import com.proj.olxshopv1.Entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortRepository extends JpaRepository<SortEntity,Long> {
    public boolean findBySortTitle(String sortTitle);

    List<SortEntity> findAllBySortTitleLike(String sortTitle);

    List<SortEntity> findAllByOrderBySortTitle();
}
