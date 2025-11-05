package com.mavenProejct.student;

import com.mavenProejct.student.model.Doctors;
import com.mavenProejct.student.service.MedicalService;
import com.mavenProejct.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppMain {
    public static void main(String[] args) {

        SpringApplication.run(AppMain.class, args);
//        var context = new AnnotationConfigApplicationContext(AppMain.class);
//            MedicalService md = context.getBean(MedicalService.class);
//
//
//        Doctors d1 = new Doctors(1, "Tanay", "Cardio-Surgion");
//        Doctors d2 = new Doctors(2, "Sandhiya", "general-doc");
//        Doctors d3 = new Doctors(3, "Chirag", "ENT-Dept");
//
//
//        md.addDoctor(d1);
//        md.addDoctor(d2);
//        md.addDoctor(d3);
//        md.getAllDoctors().stream().forEach(s->System.out.println(s.toString()));
//

//        try (var context = new AnnotationConfigApplicationContext(AppMain.class)) {
//            StudentService studentService = context.getBean(StudentService.class);
//
//            // Add a few students
//            studentService.addStudent(new String[]{"Deepak", "23"});
//            studentService.addStudent(new String[]{"Dhananjay", "42"});
//            studentService.addStudent(new String[]{"Dhanush", "35"});
//
//            studentService.getAllStudnet().stream().forEach(s->System.out.println(s.name+" "+s.rollnumber));
//
//        }
    }
}
