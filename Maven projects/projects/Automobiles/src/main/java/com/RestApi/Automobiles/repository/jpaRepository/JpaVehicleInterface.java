package com.RestApi.Automobiles.repository.jpaRepository;

import com.RestApi.Automobiles.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaVehicleInterface extends JpaRepository<Vehicle, Long> {
    List<Vehicle> getByType(com.RestApi.Automobiles.entities.VehicleType type);

}
