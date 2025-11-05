package com.mavenProejct.MavenProject_1.game;

import org.springframework.stereotype.Component;


public class MarioGame implements Gamingconsole {
    public void up(){
        System.out.println("Jump!!");
    }
    public void down(){
        System.out.println("Duck!!");
    }
    public void left(){
        System.out.println("left <-");
    }
    public void right(){
        System.out.println("right ->");
    }

}
