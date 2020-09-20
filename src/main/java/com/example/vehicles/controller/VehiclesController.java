package com.example.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.vehicles.Repository.VehiclesRepository;
import com.example.vehicles.model.Vehicle;

@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehiclesController {
	
	@Autowired
	private VehiclesRepository service;
	
	
	@PostMapping(value="/addvehicle",consumes = "application/json", produces = "application/json")
	public void addVehicle(@RequestBody Vehicle vehicle) {
		service.save(vehicle);	
		//return "Employee(s) added!";
	}
	
	@PutMapping(value="/updatevehicle")
	public void updateVehicle(@RequestBody Vehicle vehicle) {
		service.save(vehicle);
	}
	
	//@RequestMapping(method=RequestMethod.GET,value="/getvehicles",produces = "application/json")
	
	@RequestMapping(method=RequestMethod.GET,value="/getvehicles",produces = "application/json")
	public List<Vehicle> getVehicles(){
		return (List<Vehicle>) service.findAll();
	}
	
	
	
	
	
	
	
}
