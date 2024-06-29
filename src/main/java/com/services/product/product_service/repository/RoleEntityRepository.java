package com.services.product.product_service.repository;

import com.services.product.product_service.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    @Query("select r from RoleEntity r where r.roleEnum in ?1")
    List<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> roleNames);
}