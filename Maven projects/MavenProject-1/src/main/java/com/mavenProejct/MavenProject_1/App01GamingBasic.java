package com.mavenProejct.MavenProject_1;

import com.mavenProejct.MavenProject_1.game.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("com/mavenProejct/MavenProject_1/game")
public class App01GamingBasic {

//        @Bean(name = "pacmanConsole")
//        public Gamingconsole pacmanConsole(){
//            return new PacMan();
//        }

//        @Bean
//        public GameRunner gameRunner(Gamingconsole game){
//            return new GameRunner(game);
//        }


    public static void main(String[] args){
//       MarioGame marioGame=new MarioGame();
//       ContraGame contraGame=new ContraGame();
//       PacMan pacMan=new PacMan();
//         GameRunner gameRunner=new GameRunner(pacMan);
//        gameRunner.run();
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(App01GamingBasic.class);
        //System.out.println(context.getBean("pacmanConsole"));
       // context.getBean("pacmanConsole");
        context.getBean(Gamingconsole.class);
        context.getBean(GameRunner.class).run();


    }
}