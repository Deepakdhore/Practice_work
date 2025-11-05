package com.RestApi.Automobiles.repository.jpaRepository;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;
import com.RestApi.Automobiles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("JpaRepo")
public class JpaVehicleRepository implements VehicleRepository {
    @Autowired
    JpaVehicleInterface repo;
    @Override
    public List<Vehicle> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Vehicle vehicle) {
    repo.save(vehicle);
    }

    @Override
    public List<Vehicle> getByType(VehicleType type) {
        return repo.getByType(type);
    }

    @Override
    public void deleteById(Long id) {
         repo.deleteById(id);
    }
}
