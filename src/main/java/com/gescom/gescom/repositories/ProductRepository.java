package com.gescom.gescom.repositories;

import com.gescom.gescom.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();
    @RestResource(path = "/productsByKeyword")
    public List<Product> findByTitleContains(@Param("mc") String mc);
    @RestResource(path = "/promoProducts")
    public List<Product> findByPromotionIsTrue();
    @RestResource(path = "/availableProducts")
    public List<Product> findByAvailableIsTrue();
}
