package fr.adam.pokemon.pokemon.attaque;

public enum DamageType {

	PHYSIQUE("Physique"), SPECIAL("Spécial");

	String dmg;

	private DamageType(String dmg) {
		this.dmg = dmg;
	}

	public String getDmg() {
		return this.dmg;
	}
}
