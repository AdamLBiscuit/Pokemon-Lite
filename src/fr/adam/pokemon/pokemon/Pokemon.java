package fr.adam.pokemon.pokemon;

import fr.adam.pokemon.pokemon.attaque.Attaque;

public class Pokemon {

	private final String name;
	private int hp;
	private int atk;
	private int atkspe;
	private int def;
	private int defspe;
	private final Type type;
	private Attaque[] attaques = new Attaque[4];

	public Pokemon(String name, int hp, int atk, int atkspe, int def, int defspe, Type type, Attaque[] attaques) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.atkspe = atkspe;
		this.def = def;
		this.defspe = defspe;
		this.type = type;
		this.attaques = attaques;
	}

	public String getName() {
		return this.name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void addHp(int hp) {
		this.hp = this.hp + hp;
	}

	public int getAtk() {
		return this.atk;
	}

	public int getAtkSpe() {
		return this.atkspe;
	}

	public int getDef() {
		return this.def;
	}

	public int getDefSpe() {
		return this.defspe;
	}

	public Attaque[] getAttaques() {
		return this.attaques;
	}

	public Attaque getAttaque(int index) {
		return this.attaques[index];
	}

	public int getAttaqueSize() {
		int size = 0;

		for (int index = 0; index < this.attaques.length; index++) {
			if (this.attaques[index] != null) {
				size++;
			}
		}
		return size;
	}

	public void setAttaque(Attaque attaque, int index) {
		this.attaques[index] = attaque;
	}

	public void setAttaques(Attaque[] attaques) {
		this.attaques = attaques;
	}

	public Type getType() {
		return this.type;
	}

	public Pokemon clone() {
		return new Pokemon(this.name, this.hp, this.atk, this.atkspe, this.def, this.defspe, this.type, this.attaques);
	}
}
