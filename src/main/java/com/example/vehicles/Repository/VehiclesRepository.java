package com.example.vehicles.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.example.vehicles.model.Vehicle;

public interface VehiclesRepository extends CrudRepository<Vehicle,String> {

//	public void deleteVehicle(String regid);
//	public void delete(String regid);
//	void deleteByRegistrationNo(String registrationNo);
}
