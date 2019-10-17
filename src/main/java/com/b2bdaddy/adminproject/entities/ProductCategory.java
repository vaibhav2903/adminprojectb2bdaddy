package com.b2bdaddy.adminproject.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "product_categories")
public class ProductCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long categoryId;

	@Column(nullable = false)
	private String categoryName;

	@Column(name = "category_parent_id")
	private long categoryParentId;

	@Column(name = "category_level")
	private int categoryLevel;
	@Column(name = "category_status")
	private int categoryStatus;

}
