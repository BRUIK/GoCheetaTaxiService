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
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "vehicle_id")
	private String vehicle_id;


	@Column(name = "name")
	private String name;
	
	@Column(name = "seat")
	private int seat;
	
	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "vehicle_type")
	private VehicleType vehicle_type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public VehicleType getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(VehicleType vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	
}
