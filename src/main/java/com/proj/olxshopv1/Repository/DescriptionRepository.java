package com.proj.olxshopv1.Repository;

import com.proj.olxshopv1.Entity.DescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<DescriptionEntity,Long> {


}
