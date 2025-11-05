package com.mavenProejct.student.service;

import com.mavenProejct.student.model.Doctors;
import com.mavenProejct.student.repository.DoctorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MedicalService {

    @Autowired
    DoctorsRepo doctorsRepo;
    //Doctor name
    public List<Doctors> getAllDoctors(){
        return doctorsRepo.getAllDoctors();
    }
    //Doctor Speciality
    public Doctors addDoctor(Doctors doctors){
        doctorsRepo.addDoctor(doctors);
        return doctors;
    }
    //Shifts
}
