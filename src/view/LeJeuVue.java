package view;

import java.util.Observer;

import controller.LeJeuController;
import modele.LeJeu;

public abstract class LeJeuVue implements Observer {
	protected LeJeu modele;
	protected LeJeuController controller;
	
	LeJeuVue(LeJeu modele, LeJeuController controller){
		this.modele = modele;
		this.controller = controller;
		
		modele.addObserver(this);
	}

	public abstract void affiche (String string);
}
