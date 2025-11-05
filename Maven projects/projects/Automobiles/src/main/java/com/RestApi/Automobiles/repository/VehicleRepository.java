package com.RestApi.Automobiles.repository;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VehicleRepository  {


    List<Vehicle> findAll();
    void save(Vehicle vehicle);
    List<Vehicle> getByType(VehicleType type);
    void deleteById(Long id);


}
