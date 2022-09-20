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
@Table(name = "driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driver_id;
	
	@Column(name = "licence_id")
	private String license_id;
	
	@Column(name = "f_name")
	private String f_name;
	
	@Column(name = "l_name")
	private String l_name;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "userdetail_id")
	private UserDetails userdetail_id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle_id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "branch_id")
	private Branch branch_id;
	
	

	public int getDriver_id() {
		return driver_id;
	}


	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}


	public String getLicense_id() {
		return license_id;
	}
	

	public void setLicense_id(String license_id) {
		this.license_id = license_id;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDetails getUserdetail_id() {
		return userdetail_id;
	}

	public void setUserdetail_id(UserDetails userdetail_id) {
		this.userdetail_id = userdetail_id;
	}

	public Vehicle getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(Vehicle vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public Branch getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Branch branch_id) {
		this.branch_id = branch_id;
	}

}
