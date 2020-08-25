package fr.adam.pokemon.pokemon.attaque;

import java.util.ArrayList;
import java.util.List;

public class Attaques {
	
	public static final String CHARGE = "Charge";
	public static final String FLAMMECHE = "Flammeche";
	public static final String BULLES_EAU = "Bulles d'eau";
	public static final String TRANCHE_HERBE = "Tranche herbe";
	
	private final List<Attaque> attaques = new ArrayList<Attaque>();
	
	public void init() {
		this.registerAttaque(new Attaque("Charge", 10, DamageType.PHYSIQUE));
		this.registerAttaque(new Attaque("Flammeche", 10, DamageType.SPECIAL));
		this.registerAttaque(new Attaque("Bulles d'eau", 10, DamageType.SPECIAL));
		this.registerAttaque(new Attaque("Tranche herbe", 10, DamageType.SPECIAL));
	}
	
	public void registerAttaque(Attaque attaque) {
		if(!this.attaques.contains(attaque)) {
			this.attaques.add(attaque);
		}
	}
	
	public Attaque getAttaqueById(int id) {
		return this.attaques.get(id);
	}
	
	public Attaque getAttaqueByName(String name) {
		for(int index = 0; index < this.attaques.size(); index++) {
			if(name.equalsIgnoreCase(this.attaques.get(index).getName())) {
				return this.attaques.get(index);
			}
		}
		return null;
	}
}
