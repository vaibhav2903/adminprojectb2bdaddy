package com.b2bdaddy.adminproject.entities;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductCategoryTree<T> implements Iterable<ProductCategoryTree<T>> {

	private T data;
	ProductCategoryTree<T> parent;
	List<ProductCategoryTree<T>> children;
	
	public ProductCategoryTree() {
	}

	public ProductCategoryTree(T data) {
		this.data = data;
		this.children = new LinkedList<ProductCategoryTree<T>>();
	}
	
	public void clearProductCategoryTree() {
		this.data = null;
		this.children = null;
		this.parent = null;
	}

	public ProductCategoryTree<T> addChild(T child) {
		ProductCategoryTree<T> childNode = new ProductCategoryTree<T>(child);
		childNode.parent = this;
		this.children.add(childNode);
		return childNode;
	}

	@Override
	public Iterator<ProductCategoryTree<T>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductCategoryTree<T> findParentProductCategory(long categoryId) {
		if (((ProductCategory) this.data).getCategoryId() == categoryId) {
			return (ProductCategoryTree<T>) this;
		}
		for (ProductCategoryTree<T> child : children) {
			if ((ProductCategoryTree<T>) child.findParentProductCategory(categoryId) != null)
				return child;
		}
		// Finished looping over all nodes and did not find any, return null
		return null;
	}

}
