package fr.adam.pokemon.player.inventory;

import fr.adam.pokemon.pokemon.Pokemon;

public class Team {

	private final Pokemon[] pokemons = new Pokemon[6];

	public Pokemon[] getPokemons() {
		return this.pokemons;
	}

	public Pokemon getPokemon(int index) {
		return this.pokemons[index];
	}

	public void setPokemon(Pokemon pokemon, int index) {
		this.pokemons[index] = pokemon;
	}

	public boolean addPokemon(Pokemon pokemon) {
		for (int index = 0; index < this.pokemons.length; index++) {
			if (this.pokemons[index] == null) {
				this.pokemons[index] = pokemon;
				return true;
			}
		}
		return false;
	}

	public void removePokemon(int index) {
		this.pokemons[index] = null;
	}
}
