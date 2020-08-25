package fr.adam.pokemon.item;

import java.util.ArrayList;
import java.util.List;

public class Items {

	public static final String POKEBALL = "Pokeball";
	public static final String MASTER_BALL = "Master Ball";
	public static final String POTION = "Potion";
	
	private final List<Item> items = new ArrayList<Item>();
	
	public void init() {
		this.registerItem(new Ball("Pokeball", 25));
		this.registerItem(new Ball("Master Ball", 100));
		
		this.registerItem(new Potion("Potion", 5));
	}
	
	public void registerItem(Item item) {
		if(!this.items.contains(item)) {
			this.items.add(item);
		}
	}
	
	public Item getItemById(int id) {
		return this.items.get(id);
	}
	
	public Item getItemByName(String name) {
		for(int index = 0; index < this.items.size(); index++) {
			if(name.equalsIgnoreCase(this.getItemById(index).getName())) {
				return this.items.get(index);
			}
		}
		return null;
	}
}
