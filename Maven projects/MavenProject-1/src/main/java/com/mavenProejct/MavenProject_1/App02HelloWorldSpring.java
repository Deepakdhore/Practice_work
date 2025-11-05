package com.mavenProejct.MavenProject_1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //creating sprinrg context in the jvm
        //configure the things spring manages how(@Congfuguration)

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//        System.out.println(context.getBean("name"));
//        System.out.println(context.getBean("age "));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("address"));
        System.out.println(context.getBean("person2"));

    }

}
