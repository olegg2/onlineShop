package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Long>,
        JpaSpecificationExecutor<LocationEntity> {
    List<LocationEntity> findAllByOrderByTitleOfCity();
    List<LocationEntity> findAllByOrderByTitleOfStreet();
    List<LocationEntity> findAllByTitleOfCityLike(String name);
    List<LocationEntity> findAllByTitleOfStreetLike(String name);
}
