package fr.adam.pokemon.player;

import fr.adam.pokemon.player.inventory.Inventory;
import fr.adam.pokemon.player.inventory.Team;

public class Player {

	// Sac à dos
	private final Inventory inventoryBall = new Inventory();
	private final Inventory inventoryPotion = new Inventory();

	private final Team team = new Team();

	private int pokemonSelect = 0;

	public Inventory getInventoryBall() {
		return this.inventoryBall;
	}

	public Inventory getInventoryPotion() {
		return this.inventoryPotion;
	}

	public Team getTeam() {
		return this.team;
	}

	public int getSelectedPokemon() {
		return this.pokemonSelect;
	}

	public void setSelectedPokemon(int index) {
		this.pokemonSelect = index;
	}

}
