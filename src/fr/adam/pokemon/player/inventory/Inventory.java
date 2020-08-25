package fr.adam.pokemon.player.inventory;

import java.util.ArrayList;
import java.util.List;

import fr.adam.pokemon.item.Item;

public class Inventory {

	private final List<Item> items = new ArrayList<Item>();

	public List<Item> getItems() {
		return this.items;
	}

	public Item getItem(int index) {
		return this.items.get(index);
	}

	public void removeItem(int index) {
		this.items.remove(index);
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void clear() {
		this.items.clear();
	}

}
