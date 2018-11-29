package projet;
/**
 * @author kevin
 * groupe 15, 2TL2
 *
 */

import projet.Case;

/**
 * Class representing the board of the game.
 * This board contains all the cells of the goose game.
 */

public abstract class Plateau {
	
	/* number of cells of the board*/
	protected int nbDeCases;
	
	/* the cells of the board */
	protected Case[] cases;
	
	/* builds a board with a given amount of cells
	 * @param nbDeCases is the number of cells wanted
	 */
	public Plateau (int nbDeCases) {
		this.nbDeCases = nbDeCases;
	}
	
	//function that builds the board
	public abstract void initPlateau();
	
	public Case[] getCases() {
		return this.cases;
	}
	
	/* sets the cells of the board
	 * @param cases are the cells we want to set
	 */
	public void setCases(Case[] cases) {
		this.cases = cases;
	}
	
	/* get a case based on the given number
	 * @param num is the position of the cell wanted
	 */
	public Case getCase(int num) {
		return this.getCases()[num];
	}
	
	/* get the total amount of cells of the board
	 */
	public int getNbDeCases() {
		return this.nbDeCases;
	}
	

}