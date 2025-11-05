package com.RestApi.Automobiles.services;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;

import java.util.List;

public interface VehicleServices {

     List<Vehicle> getAll();
     List<Vehicle> getByType(VehicleType type);
     void delete(Long id);
     void addVehicle(Vehicle v);
}
