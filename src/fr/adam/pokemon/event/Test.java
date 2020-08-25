package fr.adam.pokemon.event;

public class Test {
	public void main() {
		int fps = 0;
		int tick = 0;
		
		while (true) {
			onkeys(0);
			display();
			
			if (tick % 10 == 0) {
				
			}
			
			if (tick % 60 == 0)
				fps++;
			else {
				fps = 0;
			}
		}
	}
	
	private void onkeys(int key) {
		if (key == 0) {
			// Avancer
		}
		if (key == 1) {
			// Reculer
		}
	}
	
	private void display() {
		
	}
}
