package com.RestApi.Automobiles.controllers;

import com.RestApi.Automobiles.entities.Vehicle;
import com.RestApi.Automobiles.entities.VehicleType;
import com.RestApi.Automobiles.services.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    public VehicleServices service;

    @Autowired
    Controller(VehicleServices service){
        this.service=service;
    }


    @GetMapping(value = "vehicle")
    public List<Vehicle> getAllvehicles(){
        List<Vehicle> all = service.getAll();
        return all;
    }

//    @RequestMapping("say-hello")
//    @ResponseBody
//    public String sayHello(){
//        return index.html;
//    }


    @PostMapping()
    public Vehicle postVehicle(@RequestBody Vehicle body){
        service.addVehicle(body);
        return body;
    }

    @GetMapping("{type}")
    public List<Vehicle> getBytype(@PathVariable VehicleType type){
        return service.getByType(type);

    }



}
