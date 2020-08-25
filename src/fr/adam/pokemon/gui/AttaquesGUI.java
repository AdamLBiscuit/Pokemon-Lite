package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemon;

public class AttaquesGUI implements IGui {

	private final Player player;
	private final Game game;
	private final Pokemon poke;

	public AttaquesGUI(Player player, Game game, Pokemon poke) {
		this.player = player;
		this.game = game;
		this.poke = poke;

	}

	@Override
	public void printGui() {
		System.out.println("========================== Liste des attaques : ==========================");

		for (int index = 0; index < this.player.getTeam().getPokemon(this.player.getSelectedPokemon())
				.getAttaqueSize(); index++) {
			System.out.println(">> " + (index + 1) + " "
					+ this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getAttaque(index).getName() + " <<");
		}
	}

	@Override
	public void actionListener(Scanner sc) {
		int choix = sc.nextInt() - 1;
		int atk = this.game.iaAttak(this.poke);

		if (choix <= this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getAttaqueSize()) {
			System.out.println(this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getName() + " utilise l'attaque " + this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getAttaque(choix).getName());
			this.game.takeDamage(this.player.getTeam().getPokemon(this.player.getSelectedPokemon()), choix, this.poke);
			if (this.poke.getHp() <= 0) {
				System.out.println("Vous avez gagné");
				return;
			}
			System.out.println(this.poke.getName() + " utilise l'attaque " + this.poke.getAttaque(atk).getName());
			this.game.takeDamage(this.poke, atk, this.player.getTeam().getPokemon(this.player.getSelectedPokemon()));
		} else {
			System.out.println("Choix incorrect, veuillez recommencer");
			AttaquesGUI attaques = new AttaquesGUI(this.player, this.game, this.poke);
			
			attaques.printGui();
			attaques.actionListener(sc);
		}
	}

}
