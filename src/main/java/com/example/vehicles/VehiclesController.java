package com.example.vehicles;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
class Vehicle {
	
	@Id
	@GeneratedValue
	private int id;
	private String registration_no;  //Primary Key
	private int resident_id; 		// Foreign Key
	private int vehicle_type;
	private String vehicle_make;
	
	public Vehicle() {}
	
	public Vehicle(String regNo, String resId, String vehType,String vehMake) {
		super();
		this.registration_no = regNo;
		this.resident_id = Integer.parseInt(resId);
		this.vehicle_type = Integer.parseInt(vehType);
		this.vehicle_make = vehMake;
		
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
}


@Repository
interface VehiclesRepository extends CrudRepository<Vehicle,Integer> {}



@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class VehiclesController {
	
	@Autowired
	private VehiclesRepository service;

	@PostMapping(value="/addvehicle")
	public void addVehicle(@RequestBody Vehicle vehicle)
	{
		System.out.println(service.count());
		if(service.count()<3)
		{
		service.save(vehicle);
		}
	}
		
	@PutMapping(value="/getvehicles/{id}")
	public void updateVehicle(@RequestBody Vehicle updated,@PathVariable int id) {
		Optional<Vehicle> veh = service.findById(id);
		updated.setId(id);
		service.save(updated);		
	}

	
	@DeleteMapping(value="/getvehicles/{id}")
	public void deleteVehicle(@PathVariable("id")  int vehid){
		service.deleteById(vehid);
		//service.delete(vehicle);	
	}
	
	
	@GetMapping(value="/getvehicles",produces = "application/json")
	public List<Vehicle> getVehicles(){
		return (List<Vehicle>) service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/getvehicles/{id}")
	public Vehicle getVehicleById(@PathVariable("id") int id)
	{
		Optional<Vehicle> vehicle=service.findById(id);
		return vehicle.get();
		
	}
	
}
