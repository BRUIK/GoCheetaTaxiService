package com.gocheeta.app.model;

import java.util.Date;

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
	@Table(name = "ride")
	public class Ride {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "pickup")
		private String pickup;
		
		@Column(name = "destination")
		private String drop;
		
		@Column(name = "price")
		private double price;
		
		@Column(name = "ridedatetime")
		private Date datetime;
		
		@Column(name = "status")
		private String status;
		
		@OneToOne(cascade = CascadeType.ALL, optional = true)
		@JoinColumn(name = "customer_id")
		private Customer customer;

		@OneToOne(cascade = CascadeType.ALL, optional = true)
		@JoinColumn(name = "branch_id")
		private Branch branch;
		
		@OneToOne(cascade = CascadeType.ALL, optional = true)
		@JoinColumn(name = "vehicle_type_id")
		private VehicleType vehicleType;
		
		
		
		public VehicleType getVehicleType() {
			return vehicleType;
		}

		public void setVehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
		}

		public Branch getBranch() {
			return branch;
		}

		public void setBranch(Branch branch) {
			this.branch = branch;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPickup() {
			return pickup;
		}

		public void setPickup(String pickup) {
			this.pickup = pickup;
		}

		public String getDrop() {
			return drop;
		}

		public void setDrop(String drop) {
			this.drop = drop;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Date getDatetime() {
			return datetime;
		}

		public void setDatetime(Date datetime) {
			this.datetime = datetime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		
}
