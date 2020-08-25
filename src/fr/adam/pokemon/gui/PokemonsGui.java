package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.player.Player;

public class PokemonsGui implements IGui {

	private final Player player;

	public PokemonsGui(Player player) {
		this.player = player;

	}

	@Override
	public void printGui() {
		System.out.println("========================== Liste de vos Pokémons : ==========================");
		for (int index = 0; index < this.player.getTeam().getPokemons().length; index++) {
			if (this.player.getTeam().getPokemon(index) != null) {
				System.out.println(">> " + (index + 1) + " " + this.player.getTeam().getPokemon(index).getName() + " <<");
			}
		}
		System.out.println("========================== Choisir lequel ? ==========================");
	}

	@Override
	public void actionListener(Scanner sc) {
		int choix = sc.nextInt() - 1;

		if (choix >= this.player.getTeam().getPokemons().length) {
			this.player.setSelectedPokemon(choix);
		}
	}

}
