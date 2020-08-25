package fr.adam.pokemon.pokemon;

import java.util.ArrayList;
import java.util.List;

import fr.adam.pokemon.Game;
import fr.adam.pokemon.pokemon.attaque.Attaque;
import fr.adam.pokemon.pokemon.attaque.Attaques;

public class Pokemons {
	
	public static final String TORTIPOUSSE = "Tortipousse"; 
	public static final String TIPLOUF = "Tiplouf"; 
	public static final String OUISTICRAM = "Ouisticram"; 
	
	private final List<Pokemon> pokemons = new ArrayList<Pokemon>();
	private final Game game;
	
	public Pokemons(Game game) {
		this.game = game;
	}
	
	public void init() {
		this.registerPokemon(new Pokemon("Tortipousse", 20, 10, 10, 10, 10, Type.PLANTE,
				new Attaque[] { this.game.getAttaques().getAttaqueByName(Attaques.CHARGE), this.game.getAttaques().getAttaqueByName(Attaques.TRANCHE_HERBE), null, null }));
		this.registerPokemon(new Pokemon("Tiplouf", 20, 10, 10, 10, 10, Type.EAU,
				new Attaque[] { this.game.getAttaques().getAttaqueByName(Attaques.CHARGE), this.game.getAttaques().getAttaqueByName(Attaques.BULLES_EAU), null, null }));
		this.registerPokemon(new Pokemon("Ouisticram", 20, 10, 10, 10, 10, Type.FEU,
				new Attaque[] { this.game.getAttaques().getAttaqueByName(Attaques.CHARGE), this.game.getAttaques().getAttaqueByName(Attaques.FLAMMECHE), null, null }));
	}
	
	public void registerPokemon(Pokemon poke) {
		if(!this.pokemons.contains(poke)) {
			this.pokemons.add(poke);
		}
	}
	
	public Pokemon getPokemonById(int id) {
		return this.pokemons.get(id).clone();
	}
	
	public Pokemon getPokemonByName(String name) {
		for(int index = 0; index < this.pokemons.size(); index++) {
			if(name.equalsIgnoreCase(this.pokemons.get(index).getName())) {
				return this.pokemons.get(index).clone();
			}
		}
		return null;
	}
}
