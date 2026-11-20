package com.practice.PRODUCT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.PRODUCT.Entity.Product;
import com.practice.PRODUCT.Entity.product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
	
	
	

}
