package com.b2bdaddy.adminproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "product_categories")
@Table(name = "product_categories", schema = "b2bdaddy")
public class ProductCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long categoryId;

	@Column(name = "category_name", nullable = false)
	private String categoryName;

	@Column(name = "category_parent_id")
	private long categoryParentId;

	@Column(name = "category_level")
	private int categoryLevel;
	@Column(name = "category_status")
	private int categoryStatus;

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getCategoryParentId() {
		return categoryParentId;
	}

	public void setCategoryParentId(long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}

	public int getCategoryLevel() {
		return categoryLevel;
	}

	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}

	public int getCategoryStatus() {
		return categoryStatus;
	}

	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
