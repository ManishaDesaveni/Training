package com.example.Springframework_Game.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	@Autowired
	private Gamingconsole game;

	public GameRunner(Gamingconsole game) {
		this.game = game;
	}

	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}

}
