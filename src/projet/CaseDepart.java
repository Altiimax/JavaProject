package projet;

import java.util.*;
/**
 * this class gives the starting cell to the players
 * @author celia, kevin arnaud
 *
 */
public class CaseDepart implements Case {
	// current place of the player
	protected int index;
	//list of players
	protected List<Joueur> lesJoueurs;
	
	public CaseDepart(int i) {
		this.index = i;
		this.lesJoueurs = new ArrayList<Joueur>();
	}
	
	public CaseDepart(int i, List<Joueur> joueurs) {
		this.index = i;
		this.lesJoueurs = joueurs;
	}

	@Override
	/*
	 * @return true because it is the beginning cell.
	 */
	public boolean peuxPartir() {
		return true;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	/*
	 * @return 0 since this is the starting cell so nobody threw the dice yet
	 */
	public int mouvements(int lancerDe) {
		return 0;
	}

	@Override
	/*
	 * @return true if a player is in the cell currently
	 */
	public boolean caseOccupee() {
		return this.lesJoueurs != null;
	}

	@Override
	/*
	 * Method not implemented since everyone is starting on this case at the start of a game
	 */
	public void remplaceJoueur(Joueur joueur) {
		
	}
	/*
	 * 
	 * @return the players currently sitting in this cell, 
	 * @return null if none
	 */
	public List<Joueur> getJoueurs() {
		return this.lesJoueurs;
	}
	
	@Override
	public Joueur getJoueur() {
		if(this.getJoueurs().size() == 0) return null;
		return this.getJoueurs().get(0);
	}

	@Override
	public void setJoueur(Joueur joueur) {
		if(!this.getJoueurs().contains(joueur)) {
			this.getJoueurs().add(joueur);
			joueur.setCaseActuelle(this);
		}
	}

	@Override
	/**
	 * this method has no effect on the starting cell
	 */
	public void passeUnTour() {
		
	}

}
