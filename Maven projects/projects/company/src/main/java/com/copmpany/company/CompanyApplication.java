package com.copmpany.company;


import com.copmpany.company.config.Mapping;
import com.copmpany.company.entities.Employee;
import com.copmpany.company.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.module.Configuration;

@SpringBootApplication
public class CompanyApplication {

	public static void main(String[] args) {

		SpringApplication.run(CompanyApplication.class, args);
		Mapping mapping =new Mapping();
		Employee e1=new Employee();
		Employee e2=new Employee();

		e1.setEid(34);
		e1.setName("Ram");
		e2.setEid(35);
		e2.setName("Shyam");

		Project p1=new Project();
		Project p2=new Project();

		p1.setPid(12121);
		p1.setProjectName("Library management");

		p2.setPid(13131);
		p2.setProjectName("chatting and the Box");

		SessionFactory sessionFactory = Mapping.getSessionFactory(); // static method
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Save entities
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		session.getTransaction().commit();
		session.close();

		System.out.println("Data saved successfully!");
	}

}
