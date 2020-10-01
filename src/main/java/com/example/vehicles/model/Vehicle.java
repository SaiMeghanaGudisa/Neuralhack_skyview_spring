package com.example.vehicles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {


	@Id
	@GeneratedValue
	private int id;
	private String registration_no;  //Primary Key
	private int resident_id; // Foreign Key
	private int vehicle_type;
	private String vehicle_make;
	//private boolean is_editable;
	public Vehicle() {}
	
	public Vehicle(String regNo, String resId, String vehType,String vehMake) {
		super();
		this.registration_no = regNo;
		this.resident_id = Integer.parseInt(resId);
		this.vehicle_type = Integer.parseInt(vehType);
		this.vehicle_make = vehMake;
		//this.is_editable = isEditable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getVehicleMake() {
		return vehicle_make;
	}

	public void setVehicleMake(String vehmodel) {
		this.vehicle_make = vehmodel;
	}

//	public boolean getIs_editable() {
//		return is_editable;
//	}
//
//	public void setIs_editable(boolean is_editable) {
//		this.is_editable = is_editable;
//	}	
}
