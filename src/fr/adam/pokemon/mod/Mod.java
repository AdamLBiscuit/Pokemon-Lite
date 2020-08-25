package fr.adam.pokemon.mod;

import fr.adam.pokemon.Game;

public class Mod {

	private Game game;
	private ModDescription desc;
	private boolean isEnable = false;
	
	public void onLoad() {}
	public void onInit() {}
	
	public void init(Game game, ModDescription desc) {
		this.game = game;
		this.desc = desc;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public ModDescription getDescription() {
		return this.desc;
	}
	
	public boolean isEnable() {
		return this.isEnable;
	}
	
	public void setEnable(boolean enable) {
		this.isEnable = enable;
	}
}

