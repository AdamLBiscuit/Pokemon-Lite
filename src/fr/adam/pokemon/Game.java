package fr.adam.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.adam.pokemon.event.Listener;
import fr.adam.pokemon.gui.BattleMenuGui;
import fr.adam.pokemon.gui.FirstPokemonGui;
import fr.adam.pokemon.item.Items;
import fr.adam.pokemon.mod.ModManager;
import fr.adam.pokemon.player.Player;
import fr.adam.pokemon.pokemon.Pokemon;
import fr.adam.pokemon.pokemon.Pokemons;
import fr.adam.pokemon.pokemon.Type;
import fr.adam.pokemon.pokemon.attaque.Attaques;
import fr.adam.pokemon.pokemon.attaque.DamageType;

public class Game {

	private final Scanner sc = new Scanner(System.in);
	
	private final Player player = new Player();
	private final Attaques attaques = new Attaques();
	private final Pokemons pokemons = new Pokemons(this);
	private final Items items = new Items();
	
	private final ModManager modManager = new ModManager(this);
	
	private final List<Listener> listeners = new ArrayList<Listener>();
	
	private boolean continu = true;

	public void startGame() {
		this.modManager.detectMods();
		this.modManager.loadMods();
		
		this.attaques.init();
		this.pokemons.init();
		this.items.init();
		
		this.modManager.initMods();
		
		firstPokemon();
		
		this.player.getInventoryBall().addItem(this.items.getItemByName(Items.MASTER_BALL));
		this.player.getInventoryPotion().addItem(this.items.getItemByName(Items.POTION));
		
		startBattle(this.pokemons.getPokemonByName(Pokemons.TIPLOUF));
		startBattle(this.pokemons.getPokemonByName(Pokemons.OUISTICRAM));
	}

	public void firstPokemon() {
		FirstPokemonGui first = new FirstPokemonGui(this.player, this);

		first.printGui();
		first.actionListener(sc);
	}

	public void startBattle(Pokemon poke) {
		if(poke == null) {
			System.err.println("Pokemon invalide !");
			return;
		}
		for(Listener listener : this.listeners) {
			listener.onStartBattle(poke);
		}
		
		BattleMenuGui gui = new BattleMenuGui(this.player, this, poke);

		System.out.println("Vous entrez en combat avec " + poke.getName());
		this.continu = true;
		while (poke.getHp() > 0 && this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).getHp() > 0 && this.continu) {
			if (!this.continu) {
				break;
			}
			gui.printGui();
			if (!this.continu) {
				break;
			}
			gui.actionListener(sc);
		}
		
		for(Listener listener : this.listeners) {
			listener.onFinishBattle(poke);
		}
	}

	public void takeDamage(Pokemon pokeAtk, int atkIndex, Pokemon pokeVictime) {
		int takeDamage = 0;

		if (pokeAtk.getAttaque(atkIndex).getDmg() == DamageType.PHYSIQUE) {
			takeDamage = pokeAtk.getAttaque(atkIndex).getPuissance() + pokeAtk.getAtk() - pokeVictime.getDef();
		} else if (pokeAtk.getAttaque(atkIndex).getDmg() == DamageType.SPECIAL) {
			takeDamage = pokeAtk.getAttaque(atkIndex).getPuissance() + pokeAtk.getAtkSpe() - pokeVictime.getDefSpe();
		}
		if (pokeAtk.getType() == Type.EAU && pokeVictime.getType() == Type.FEU) {
			takeDamage = takeDamage * 2;
			System.out.println("C'est très efficace !");
		} else if (pokeAtk.getType() == Type.EAU && pokeVictime.getType() == Type.PLANTE) {
			takeDamage = takeDamage / 2;
			System.out.println("Ce n'est pas très efficace !");
		} else if (pokeAtk.getType() == Type.PLANTE && pokeVictime.getType() == Type.EAU) {
			takeDamage = takeDamage * 2;
			System.out.println("C'est très efficace !");
		} else if (pokeAtk.getType() == Type.PLANTE && pokeVictime.getType() == Type.FEU) {
			takeDamage = takeDamage / 2;
			System.out.println("Ce n'est pas très efficace !");
		} else if (pokeAtk.getType() == Type.FEU && pokeVictime.getType() == Type.PLANTE) {
			takeDamage = takeDamage * 2;
			System.out.println("C'est très efficace !");
		} else if (pokeAtk.getType() == Type.FEU && pokeVictime.getType() == Type.EAU) {
			takeDamage = takeDamage / 2;
			System.out.println("Ce n'est pas très efficace !");
		}
		if (takeDamage < 0) {
			takeDamage = 0;
		}

		System.out.println(pokeVictime.getName() + " à perdu " + takeDamage + " Hp");
		System.out.println("============================================================");
		pokeVictime.setHp(pokeVictime.getHp() - takeDamage);
	}

	public int iaAttak(Pokemon poke) {

		return (int) (Math.random() * poke.getAttaqueSize());
	}

	public void catchPokemon(Pokemon pokemon, int rate) {
		int chance = (int) (Math.random() * 100);
		
		if (rate >= chance) {
			this.player.getTeam().addPokemon(pokemon);
			System.out.println(">> Vous venez de capturer " + pokemon.getName());
		} else {
			System.out.println(">> Echec de la capture de " + pokemon.getName());
		}
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Attaques getAttaques() {
		return this.attaques;
	}
	
	public Pokemons getPokemons() {
		return this.pokemons;
	}
	
	public Items getItems() {
		return this.items;
	}
	
	public boolean getContinu() {
		return this.continu;
	}
	
	public void setContinu(boolean c) {
		this.continu = c;
	}
	
	public void registerListener(Listener listener) {
		this.listeners.add(listener);
	}
}