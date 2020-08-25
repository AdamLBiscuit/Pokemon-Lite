package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemon;

public class BattleMenuGui implements IGui {

	private final Player player;
	private final Game game;
	private final Pokemon poke;

	public BattleMenuGui(Player player, Game game, Pokemon poke) {
		this.player = player;
		this.game = game;
		this.poke = poke;
	}

	@Override
	public void printGui() {
		System.out.println("========================== Pokémon combattant : "
				+ this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getName() + " ==========================");
		System.out.println("========================== Que voulez vous faire ? ==========================");
		System.out.println("1 >> Attaques <<");
		System.out.println("2 >> Sac <<");
		System.out.println("3 >> Pokémons <<");
	}

	@Override
	public void actionListener(Scanner sc) {
		switch (sc.nextInt()) {
		case 1:
			AttaquesGUI attaques = new AttaquesGUI(this.player, this.game, this.poke);
			
			attaques.printGui();
			attaques.actionListener(sc);
			break;
		case 2:
			BagGui bag = new BagGui(this.player, this.game, this.poke);
			
			bag.printGui();
			bag.actionListener(sc);
			break;
		case 3:
			PokemonsGui pokémons = new PokemonsGui(this.player);
			
			pokémons.printGui();
			pokémons.actionListener(sc);
			break;
		case 4:
		}

	}
}
