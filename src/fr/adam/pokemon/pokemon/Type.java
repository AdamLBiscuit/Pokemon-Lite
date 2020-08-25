package fr.adam.pokemon.pokemon;

public enum Type {
	PLANTE("Plante"), FEU("Feu"), EAU("Eau"), NORMAL("Normal");

	private String type;

	private Type(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
}
