package com.example.vehicles.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Vehicle")

public class Vehicle {

	@Id
	private String registration_no;  //Primary Key
	private int resident_id; // Foreign Key
	private int vehicle_type;
	
	public Vehicle() {}
	
	public Vehicle(String regNo, int resId, int vehType) {
		super();
		this.registration_no = regNo;
		this.resident_id = resId;
		this.vehicle_type = vehType;
	}

	public String getRegistrationNo() {
		return registration_no;
	}

	public void setRegistrationNo(String regNo) {
		this.registration_no = regNo;
	}

	public int getResidentId() {
		return resident_id;
	}

	public void setResidentId(int resId) {
		this.resident_id = resId;
	}

	public int getVehicleType() {
		return vehicle_type;
	}

	public void setVehicleType(int vehType) {
		this.vehicle_type = vehType;
	}
	
	
	
	
	
}
