package com.gradleProjet.Learn_spring_aop;

import com.gradleProjet.Learn_spring_aop.bussiness.BussinessService;
import com.gradleProjet.Learn_spring_aop.bussiness.BussinessService2;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {
	@Autowired
	private BussinessService bussinessService;
	@Autowired
	private BussinessService2 bussinessService2;
	//private Logger logger= LoggerFactory.getLogger(getClass());
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
     // logger.info("Value returned is {}",bussinessService.calculateMax());

		bussinessService.calculateMax();
		bussinessService2.calculateMax();
	}
}