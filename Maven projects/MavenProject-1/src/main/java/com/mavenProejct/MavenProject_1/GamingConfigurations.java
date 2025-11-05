package com.mavenProejct.MavenProject_1;

import com.mavenProejct.MavenProject_1.game.GameRunner;
import com.mavenProejct.MavenProject_1.game.Gamingconsole;
import com.mavenProejct.MavenProject_1.game.PacMan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfigurations {
    @Bean(name = "pacmanConsole")
    public Gamingconsole pacmanConsole(){
        return new PacMan();
    }

    @Bean
    public GameRunner gameRunner(){
        return new GameRunner(pacmanConsole());
    }

}
