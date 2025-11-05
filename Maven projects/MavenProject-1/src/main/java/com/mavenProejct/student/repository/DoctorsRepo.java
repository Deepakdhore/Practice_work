package com.mavenProejct.student.repository;

import com.mavenProejct.student.model.Doctors;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorsRepo {


    ArrayList<Doctors> doctors=new ArrayList<>();

    public Doctors addDoctor(Doctors d1)
    {
        doctors.add(d1);
        return d1;
    }

    public List<Doctors> getAllDoctors() {
        return doctors;
    }
}
