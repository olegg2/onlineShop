package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.CommodityEntity;
import com.proj.olxshopv1.Entity.TypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<CommodityEntity,Long>, JpaSpecificationExecutor<CommodityEntity> {
    CommodityEntity findCommodityEntityById(Long id);
    Page<CommodityEntity> findAllByCommodityTitleLike(String name, Pageable pageable);
    Page<CommodityEntity> findAllByTypeLike(TypeEntity typeEntity,Pageable pageable);
    List<CommodityEntity> findAllByOrderByCommodityTitle();
    List<CommodityEntity> findCommodityEntitiesByCommodityTitle(String title);
    List<CommodityEntity> findAllByType(TypeEntity typeEntity);


}
