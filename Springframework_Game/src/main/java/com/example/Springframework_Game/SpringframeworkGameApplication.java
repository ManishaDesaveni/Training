package com.example.Springframework_Game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Springframework_Game.example.Webcontroller;

@SpringBootApplication
public class SpringframeworkGameApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringframeworkGameApplication.class, args);
		// MarioGame game = new MarioGame();
		// Supercontra game = new Supercontra();
		// GameRunner runner = new GameRunner(game);
		// GameRunner runner = context.getBean(GameRunner.class);
		// runner.run();
		Webcontroller web = context.getBean(Webcontroller.class);
		System.out.println(web.returnval());
	}

}
