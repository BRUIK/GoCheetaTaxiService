package com.gocheeta.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cus_id;

	@Column(name = "mobile")
	private int mobile;
	@Column(name = "f_name")
	private String f_name;
	@Column(name = "l_name")
	private String l_name;
	@Column(name = "email")
	private String email;
	@Column(name = "address")
	private String address;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "userdetail_id")
	private UserDetails userdetail_id;

	public int getCus_id() {
		return cus_id;
	}

	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDetails getUserdetail_id() {
		return userdetail_id;
	}

	public void setUserdetail_id(UserDetails userdetail_id) {
		this.userdetail_id = userdetail_id;
	}

	
}
