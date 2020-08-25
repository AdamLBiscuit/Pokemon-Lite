package fr.adam.pokemon.item;

public class Potion extends Item {

	private final int heal;
	private final String name;

	public Potion(String name, int heal) {
		super(name);
		this.name = name;
		this.heal = heal;
	}

	public String getName() {
		return this.name;
	}

	public int getHeal() {
		return this.heal;
	}
}
