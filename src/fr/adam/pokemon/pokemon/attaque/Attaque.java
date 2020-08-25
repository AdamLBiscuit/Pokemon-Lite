package fr.adam.pokemon.pokemon.attaque;

public class Attaque {

	private final String name;
	private final int puissance;
	private final DamageType dmg;

	public Attaque(String name, int puissance, DamageType dmg) {
		this.name = name;
		this.puissance = puissance;
		this.dmg = dmg;
	}

	public String getName() {
		return this.name;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public DamageType getDmg() {
		return this.dmg;
	}
}
