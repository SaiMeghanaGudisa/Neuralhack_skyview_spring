package com.example.vehicles.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.vehicles.model.Vehicle;

public interface VehiclesRepository extends CrudRepository<Vehicle,String> {

}
