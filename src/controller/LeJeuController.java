package controller;

import modele.LeJeu;
import view.LeJeuVue;

public class LeJeuController {
	LeJeu modele;
	LeJeuVue vue;
	
	public LeJeuController(LeJeu modele) {
		this.modele = modele;
	}
	
	public void lanceDe() {
		modele.lanceDe();
	}
	
	
}
