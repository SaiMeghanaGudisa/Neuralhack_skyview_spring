package com.example.vehicles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.vehicles.Repository.VehiclesRepository;
import com.example.vehicles.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonValue;

//import com.fasterxml.jackson.databind.ObjectMapper;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping(value="/vehicle", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class VehiclesController {
	
	@Autowired
	private VehiclesRepository service;
	int count=0;
	//List <Vehicle> vehicles=new ArrayList<Vehicle>();
	//private ArrayList[] objects;
	//private List<Vehicle> vehicles;
	
	//@PostMapping(value="/addvehicle",consumes = "application/json", produces = "application/json")
	//public void addVehicle(@RequestBody Object obj) {
		// List list = java.util.Arrays.asList(obj.toString());
		// for(int i=0;i<list.size();i++)
		// 	service.save(list.get(i));
		// for(Vehicle veh:obj){
		// 	vehicles.add(veh);
		// }

		
		//@RequestMapping(method=RequestMethod.POST,value="/addvehicle",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//		@RequestMapping(method=RequestMethod.POST,value="/addvehicle", consumes = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(method=RequestMethod.POST,value="/addvehicle",consumes="application/json")
//		public void addVehicle(@RequestBody JsonObject obj)
//		{
//			for(int i=0;i<obj.size();i++)
//			{
//				JsonArray array= (JsonArray) obj.get(i);
//				//service.saveAll(array);
//				System.out.print(array);
//			}
//			for(int i=0;i<arr.size();i++)
//			{
//				Vehicle veh=(Vehicle) arr.get(i);
//				service.save(veh);
//			}
			//for(Vehicle veh: vehicle)
				//service.save(veh);
			//List<String> response = new ArrayList<String>();
			//System.out.println(vehicle);
//			for(int i=0;i<jsonObject.length;i++)
//			{
//				JsonArray array= jsonObject.get(i)
//			}
//			JsonArray array= jsonObject.getJsonArray("tableRows");
//			for(javax.json.JsonValue val: array)
//			{
//				service.save((Vehicle) val);
//			}
		//}
	@PostMapping(value="/addvehicle")
	public void addVehicle(@RequestBody Vehicle vehicle)
	{
		if(count<3)
		{
		service.save(vehicle);
		count++;
		}
	}
		
	@PutMapping(value="/getvehicles/{id}")
	public void updateVehicle(@RequestBody Vehicle updated,@PathVariable int id) {
		Optional<Vehicle> veh = service.findById(id);
//		vehicle.setId(id);
//		service.save(vehicle);
		updated.setId(id);
		service.save(updated);		
	}

	//@DeleteMapping(value = "/deletevehicle")
	
	@DeleteMapping(value="/getvehicles/{id}")
	public void deleteVehicle(@PathVariable("id")  int vehid){
		service.deleteById(vehid);
		//service.delete(vehicle);	
		count--;
	}
	
	//@RequestMapping(method=RequestMethod.GET,value="/getvehicles",produces = "application/json")
	
	@RequestMapping(method=RequestMethod.GET,value="/getvehicles",produces = "application/json")
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
