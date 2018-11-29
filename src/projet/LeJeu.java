package projet;

import java.util.*;

public class LeJeu {
	
	private List<Joueur> lesJoueurs = new ArrayList<Joueur>();
	
	private Plateau plateau;
	
	private boolean partieTerminee;
	
	/* Constructor for Game */
	public LeJeu (Plateau initPlateau) {
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
	
	/** Get the current board
	 * @return the board
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	/** Add a player in the game and assigns him to the first cell
	 * @param p is the new player to add
	 */
	public void addJoueur(Joueur p) {
		this.lesJoueurs.add(p);
		this.getPlateau().getCases()[0].setJoueur(p);
	}
	
	public void playOneTime(){
		
		int boardSize = this.getPlateau().getNbDeCases() - 1;
		
		/* For each player we are going to throw the dice */
		oneRound:
		for (Joueur p : lesJoueurs) {
			
			/*We check if the player can leave the cell */
			if (p.getCaseActuelle().peuxPartir()) {
				
				int result = p.lanceDé();
				
				/* Compute the new index of the player */
				int indexActuel = p.getCaseActuelle().getIndex();
				int indexDestHypo = indexActuel + result;
				int indexInter;
				int indexDestFinale;
				
				/* If the player is not out of the board */
				if (indexDestHypo < boardSize + 1) {
					indexInter = indexDestHypo;
					indexDestFinale = this.getPlateau().getCase(indexInter).mouvements(result);
				} else {
					indexInter = boardSize - (result - (boardSize - indexActuel));
					indexDestFinale = indexInter;
				}
				
				/* gives the status of the player */
				System.out.print(p.toString() + " est à la case " +indexActuel +".");
				System.out.println(" il jette " +result + " et atteint " +indexInter +".");
				
				Case destinationCell = this.getPlateau().getCase(indexDestFinale);
								
				destinationCell.remplaceJoueur(p);
				p.setCaseActuelle(destinationCell);
				this.getPlateau().getCase(indexDestFinale).setJoueur(p);
				
				/* Check if there is a winner */
				if (indexDestFinale == boardSize) {
					System.out.println(p.toString() + " est à la case " +indexDestFinale
							+". c'est la dernière case du plateau, " + p.toString()+ " a gagné!");
					this.setPartieTerminee(true);
					break oneRound;
				}
			} else {
				p.getCaseActuelle().passeUnTour();
			}
			
		}
		
	}
	
	
	public void playManyTimes(int Nmax) {
		int i = 0;
		while (i < Nmax & !this.getPartieTerminee()) {
			System.out.println("Round " +i);
			this.playOneTime();
			i++;
		}
	}

}