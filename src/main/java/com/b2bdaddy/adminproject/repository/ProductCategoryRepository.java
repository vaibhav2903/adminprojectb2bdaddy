package com.b2bdaddy.adminproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2bdaddy.adminproject.entities.ProductCategory;

@Repository(value = "productrepo")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	void deleteByCategoryId(long categoryId);
}
