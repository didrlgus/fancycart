package com.shoppingmall.fancycart.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findBySmallCatCd(String categoryCd, Pageable pageable);

    Product findByProductNmOrderByCreatedDateDesc(String productNm);
}
