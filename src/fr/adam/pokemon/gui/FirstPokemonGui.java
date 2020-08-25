package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemons;

public class FirstPokemonGui implements IGui {

	private final Player player;
	private final Game game;

	public FirstPokemonGui(Player player, Game game) {
		this.player = player;
		this.game = game;
	}

	@Override
	public void printGui() {
		System.out.println("========================== Choisis ton pokémon ==========================");
		System.out.println("1 >> Choisir Tortipousse <<");
		System.out.println("2 >> Choisir Tiplouf <<");
		System.out.println("3 >> Choisir Ouisticram");

	}

	@Override
	public void actionListener(Scanner sc) {

		switch (sc.nextInt()) {
		case 1:
			this.player.getTeam().addPokemon(this.game.getPokemons().getPokemonByName(Pokemons.TORTIPOUSSE));
			System.out.println("Vous venez de récupérer Tortipousse");
			break;
		case 2:
			this.player.getTeam().addPokemon(this.game.getPokemons().getPokemonByName(Pokemons.TIPLOUF));
			System.out.println("Vous venez de récupérer Tiplouf");
			break;
		case 3:
			this.player.getTeam().addPokemon(this.game.getPokemons().getPokemonByName(Pokemons.OUISTICRAM));
			System.out.println("Vous venez de récupérer Ouisticram");
			break;
		}
	}

}
