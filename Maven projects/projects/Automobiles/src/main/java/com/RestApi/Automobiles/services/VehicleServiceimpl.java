package com.RestApi.Automobiles.services;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;
import com.RestApi.Automobiles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceimpl implements VehicleServices{

    private final VehicleRepository repository;
    @Autowired
    public VehicleServiceimpl(@Qualifier("jdbcRepo") VehicleRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Vehicle> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Vehicle> getByType(VehicleType type) {
        return repository.getByType(type);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void addVehicle(Vehicle v) {
        repository.save(v);
    }
}
