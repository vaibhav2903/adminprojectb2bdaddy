package com.b2bdaddy.adminproject.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

//@Entity
public class ProductItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productID;
	private String title;
	private int Quantity;
	private Object itemDescription;
	private List<Object> productDescription;
	private List<String> imageUrl;
	private int category;
	private int subcategory;
	

}
