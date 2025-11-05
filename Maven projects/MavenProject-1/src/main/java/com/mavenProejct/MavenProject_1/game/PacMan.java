package com.mavenProejct.MavenProject_1.game;

import org.springframework.stereotype.Component;

@Component
public class PacMan implements Gamingconsole{
    @Override
    public void up() {
        System.out.println("Move UP");
    }

    @Override
    public void down() {
        System.out.println("Move Down");
    }

    @Override
    public void left() {
        System.out.println("Move Left");
    }

    @Override
    public void right() {
        System.out.println("Move Right");
    }

    public void enter(){
        System.out.println("Entering Ghost Eating mode");
    }
}
