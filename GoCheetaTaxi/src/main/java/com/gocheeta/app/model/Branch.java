package com.gocheeta.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbranch;
	
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private int phone;
	
	public int getIdbranch() {
		return idbranch;
	}
	public void setIdbranch(int idbranch) {
		this.idbranch = idbranch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
}