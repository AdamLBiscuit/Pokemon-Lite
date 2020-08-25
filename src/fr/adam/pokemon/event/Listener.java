package fr.adam.pokemon.event;

import fr.adam.pokemon.pokemon.Pokemon;

public abstract class Listener {

	public void onStartBattle(Pokemon poke) {}
	
	public void onFinishBattle(Pokemon poke) {}
	
}
