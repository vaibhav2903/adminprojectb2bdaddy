package com.b2bdaddy.adminproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.b2bdaddy.adminproject.entities.ProductCategory;
import com.b2bdaddy.adminproject.entities.ProductCategoryTree;
import com.b2bdaddy.adminproject.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {

	ProductCategoryRepository productCategoryRepo;

	private static ApplicationContext applicationContext;

	@Autowired
	ProductCategoryRepository repo;

	private static ProductCategoryTree<ProductCategory> rootProductCategoryTree;

	public final ProductCategoryTree<ProductCategory> getRootProductCategoryTree() {

		return rootProductCategoryTree;
	}

	private static ProductCategoryTree<ProductCategory> getProductCategoryTree() {

		ProductCategory rootCategory = new ProductCategory();
		rootCategory.setCategoryName("Home");
		rootCategory.setCategoryLevel(0);

		ProductCategoryTree<ProductCategory> rootProductCategory = new ProductCategoryTree<ProductCategory>(
				rootCategory);
		ProductCategoryRepository productrepo = ((ProductCategoryRepository) applicationContext.getBean("productrepo"));
		List<ProductCategory> categories = productrepo.findAll();

		for (ProductCategory productCategory : categories) {
			if (productCategory.getCategoryParentId() == 1) {
				rootProductCategory.addChild(productCategory);
			} else {
				ProductCategoryTree<ProductCategory> parentCategoryTree = rootProductCategory
						.findParentProductCategory(productCategory.getCategoryParentId());
				parentCategoryTree.addChild(productCategory);
			}
		}
		rootProductCategoryTree = rootProductCategory;
		return rootProductCategory;
	}

	public void clearCategoryTree() {
		List<ProductCategory> categories = repo.findAll();
		System.out.println(categories.toString());
		getProductCategoryTree();
	}

}
