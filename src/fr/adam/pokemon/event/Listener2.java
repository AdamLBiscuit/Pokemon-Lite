package fr.adam.pokemon.event;

import fr.adam.pokemon.pokemon.Pokemon;

public interface Listener2 {

	void onStartBattle(Pokemon poke);
	
	void onFinishBattle(Pokemon poke);
	
}
