package com.gocheeta.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvehicle_type;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	public int getIdvehicle_type() {
		return idvehicle_type;
	}

	public void setIdvehicle_type(int idvehicle_type) {
		this.idvehicle_type = idvehicle_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
