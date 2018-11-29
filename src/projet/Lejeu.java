package projet;

import java.util.*;

public class Lejeu {
	
	private List<Joueur> lesJoueurs = new ArrayList<Joueur>();
	
	private Plateau plateau;
	
	private boolean partieTerminee;
	
	/* Constructor for Game */
	public Lejeu (Plateau initPlateau) {
		this.plateau = initPlateau;
		this.lesJoueurs = new ArrayList<Joueur> ();
		this.partieTerminee = false;
	}
	
	/**
	 * @return true if the game is finished
	 */
	public boolean getPartieTerminee() {
		return this.partieTerminee;
	}
	
	/** Sets a game to finished or not
	 * @param k is the status to set
	 */
	public void setPartieTerminee(boolean k) {
		this.partieTerminee = k;
	}
}