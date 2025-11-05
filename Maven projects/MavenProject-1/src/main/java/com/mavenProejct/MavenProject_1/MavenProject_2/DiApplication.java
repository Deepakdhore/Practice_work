package com.mavenProejct.MavenProject_1.MavenProject_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class BussinessClass{
    Dependency1 dependency1;

    Dependency2 dependency2;
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("This is setter injection 1");
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("This is setter injection 2");
        this.dependency2 = dependency2;
    }

    @Override
    public String toString() {
        return "this is to string method of the BussinessClass \nhaving "+dependency1+" and "+dependency2;
    }
}
@Component
class Dependency1{
    @Override
    public String toString() {
        return "Dep1";
    }
}
@Component
class Dependency2{
    @Override
    public String toString() {
        return "Dep2";
    }
}
@Configuration
@ComponentScan
public class DiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DiApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(BussinessClass.class));
        context.getBean(BussinessClass.class).setDependency1(null);
        }

}

