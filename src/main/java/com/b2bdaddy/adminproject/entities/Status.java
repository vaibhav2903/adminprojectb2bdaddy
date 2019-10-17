package com.b2bdaddy.adminproject.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity(name = "status")
public class Status implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String statusName;
	private Timestamp createdAt;
	private Timestamp updatedAt;

}
