package com.mavenProejct.MavenProject_1.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    Gamingconsole game;

    public GameRunner(Gamingconsole game){
        this.game=game;
    }
    public void run() {
        System.out.println("Running game = "+game );
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
