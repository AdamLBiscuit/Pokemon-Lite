package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemon;

public class BagGui implements IGui {
	private final Player player;
	private final Game game;
	private final Pokemon poke;

	public BagGui(Player player, Game game, Pokemon poke) {
		this.player = player;
		this.game = game;
		this.poke = poke;

	}

	@Override
	public void printGui() {
		System.out.println("========================== Bag ==========================");
		System.out.println(">> 1 Potions <<");
		System.out.println(">> 2 Balls <<");
		System.out.println(">> 3 Retour <<");
	}

	@Override
	public void actionListener(Scanner sc) {
		switch (sc.nextInt()) {
		case 1:
			PotionGui potgui = new PotionGui(player);
			
			potgui.printGui();
			potgui.actionListener(sc);
			break;
		case 2:
			BallGui ballgui = new BallGui(player, game, poke);
			
			ballgui.printGui();
			ballgui.actionListener(sc);
			break;
		case 3:
			break;
		}
	}
}
