package fr.adam.pokemon.gui;

import java.util.Scanner;

import fr.adam.pokemon.item.Potion;
import fr.adam.pokemon.player.Player;

public class PotionGui implements IGui {
	private final Player player;

	public PotionGui(Player player) {
		this.player = player;
	}

	@Override
	public void printGui() {
		System.out.println("========================== Liste des potions ==========================");
		int index = 0;

		for (index = 0; index < this.player.getInventoryPotion().getItems().size(); index++) {
			System.out
					.println(">> " + (index + 1) + " " + this.player.getInventoryPotion().getItem(index).getName() + " <<");
		}
		System.out.println(">> " + (index + 1) + " Retour <<");
	}

	@Override
	public void actionListener(Scanner sc) {
		int choix = sc.nextInt() - 1;

		if (choix < player.getInventoryPotion().getItems().size()) {
			Potion potion = (Potion) this.player.getInventoryPotion().getItem(choix);
			
			this.player.getTeam().getPokemon(this.player.getSelectedPokemon()).addHp(potion.getHeal());

			System.out.println(">> " + player.getTeam().getPokemon(this.player.getSelectedPokemon()).getName()
					+ " à regagné " + potion.getHeal() + " HP <<");
			this.player.getInventoryPotion().removeItem(choix);
		}
	}

}
