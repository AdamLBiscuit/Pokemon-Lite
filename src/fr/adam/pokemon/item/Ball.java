package fr.adam.pokemon.item;

public class Ball extends Item {

	private final int rate;

	public Ball(String name, int rate) {
		super(name);
		this.rate = rate;
	}

	public int getRate() {
		return this.rate;
	}

}
