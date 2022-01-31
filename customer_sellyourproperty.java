package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_sellyourproperty")
public class customer_sellyourproperty {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "email",nullable = false,length = 50)
	private String email;
	@Column(name="cropname")
	private String cropname;
	@Column(name="quantity")
	private String quantity;
	@Column(name="cost")
	private int cost;
	@Column(name="status")
	private String status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCropname() {
		return cropname;
	}
	public void setCropname(String cropname) {
		this.cropname = cropname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
