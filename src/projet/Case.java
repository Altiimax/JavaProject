package projet;

import projet.Joueur;

/**
 * Interface for the cells of the game.
 * Only one player can be in a given case, except for the starting one (case 0).
 */
public interface Case {
	/**
	 * @return true if the player that is in this cell can leave it
	 * @return false if the player in this cell cannot leave it for a given reason.
	 */
	public boolean peuxPartir();

	/** returns the index of this cell */
	public int getIndex();

	  /**
     * returns the index of the cell reached by a player with the number he got on the dice that led him to this case
     * so we can further use this amount of the dice to move him or do a specific action on this player based on the dice roll
     * @param lancerDé the result of the dice throw
     * @return the index of the cell where the player should arrive after throwing the dice
     */
	public int mouvements(int lancerDé);

	/** @return true if the case is busy*/
	public boolean caseOccupee();

	 /** 
     * @param joueur is the player who just reached this cell
     */
	public void welcomeJoueur(Joueur joueur);

	/** gets the name of the player in the cell, returns none if null*/
	public Joueur getJoueur();
	
	/** sets the player in the cell
	 * @param joueur is the player to set
	 */
	public void setPlayer(Joueur joueur);
	
	/** function that dictates what happens on special cases (trap, enigma, etc)*/
	public void passeUnTour();
}
