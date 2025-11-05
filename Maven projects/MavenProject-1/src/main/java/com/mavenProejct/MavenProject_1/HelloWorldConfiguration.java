package com.mavenProejct.MavenProject_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age){};
record Address(String firstline,String city){};
// record is used to create a class wihtout explicitlty definfing constructor,gettter,seter,to string ===automatic
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Deepak";
    }
    @Bean
    public int age(){
        return 23;
    }

    @Bean
    public Person person(){
        return new Person("Deepak",23);
    }
    @Bean
    public Address address(){
        return new Address("Batman","Arkham Asylam");
    }
    @Bean
    public Person person2(){
        return new Person(name(),age());
    }

}
