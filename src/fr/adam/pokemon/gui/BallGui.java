package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.item.Ball;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemon;

public class BallGui implements IGui {
	private final Player player;
	private final Game game;
	private final Pokemon poke;

	public BallGui(Player player, Game game, Pokemon poke) {
		this.player = player;
		this.game = game;
		this.poke = poke;
	}

	@Override
	public void printGui() {
		System.out.println("========================== Liste des Ball ==========================");
		int index = 0;

		for (index = 0; index < this.player.getInventoryBall().getItems().size(); index++) {
			System.out.println(">> " + (index + 1) + " " + this.player.getInventoryBall().getItem(index).getName() + " <<");
		}
		System.out.println(">> " + (index + 1) + " Retour <<");
	}

	@Override
	public void actionListener(Scanner sc) {
		int choix = sc.nextInt() - 1;

		if (choix < player.getInventoryBall().getItems().size()) {
			Ball ball = (Ball) this.player.getInventoryBall().getItem(choix);
			
			this.game.catchPokemon(this.poke, ball.getRate());
			this.player.getInventoryBall().removeItem(choix);
			this.game.setContinu(false);
		}
	}

}
