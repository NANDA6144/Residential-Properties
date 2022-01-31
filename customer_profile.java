package com.klef.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="customer_profile")
public class customer_profile {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="name")
	private String name;
	@Column(name = "email",nullable = false,length = 50)
	private String email;
	@Column(name="phonenumber")
	private String phonenumber;
	@Column(name="address")
	private String address;
	@Column(name="password")
	private String password;

	private String photos;
	
	@Lob
	@Column(columnDefinition="LONGBLOB")
	private String photos() {
		return null;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhotos() {
	    return photos();
	  }

	  public void setPhotos(String photos) {
	    this.photos = photos;
	  }

}
