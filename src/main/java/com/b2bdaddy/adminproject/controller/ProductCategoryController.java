package com.b2bdaddy.adminproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2bdaddy.adminproject.entities.ProductCategory;
import com.b2bdaddy.adminproject.entities.ProductCategoryTree;
import com.b2bdaddy.adminproject.repository.ProductCategoryRepository;
import com.b2bdaddy.adminproject.service.ProductCategoryService;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

	private ProductCategoryService productCategoryService;
	private ProductCategoryRepository productCategoryRepo;

	@Autowired
	public ProductCategoryController(ProductCategoryService productCategoryService,
			ProductCategoryRepository productCategoryRepo) {
		this.productCategoryService = productCategoryService;
		this.productCategoryRepo = productCategoryRepo;
	}

	@GetMapping("/productCategories")
	public ProductCategoryTree<ProductCategory> fetchProductCategories() {
		return productCategoryService.getRootProductCategoryTree();
	}

	@PostMapping("/productCategories")
	public ProductCategory updateProductCategory(@RequestBody ProductCategory category) {
		return productCategoryRepo.save(category);
	}

	@PutMapping("/productCategories")
	public ProductCategory addProductCategory(@RequestBody ProductCategory category) {
		return productCategoryRepo.save(category);
	}

	@DeleteMapping("/productCategories")
	public void deleteProductCategory(@RequestParam long categoryId) {
		// productCategoryRepo.deleteByCategoryId(categoryId);
		return;
	}
	
	@GetMapping("/clearCache")
	public void clearCache() {
		productCategoryService.clearCategoryTree();
	}
}
