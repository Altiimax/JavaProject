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
	
	/*
	 * @return true if the game is finished
	 */
	public boolean getPartieTerminee() {
		return this.partieTerminee;
	}
	
	/* Sets a game to finished or not
	 * @param k is the status to set
	 */
	public void setPartieTerminee(boolean k) {
		this.partieTerminee = k;
	}
	
	/* Get the current board
	 * @return the board
	 */
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	/*Add a player in the game and assigns him to the first cell
	 * @param p is the new player to add
	 */
	public void addJoueur(Joueur p) {
		this.lesJoueurs.add(p);
		this.getPlateau().getCases()[0].setJoueur(p);
	}
	
	public void jeuUn(){
		int result = 0;
		int boardSize = this.getPlateau().getNbDeCases() - 1;
		
		/* For each player we are going to throw the dice */
		oneRound:
		for (Joueur p : lesJoueurs) {
			
			/*We check if the player can leave the cell */
			if (p.getCaseActuelle().peuxPartir()) {
				
				result = p.lanceDe();
				
				/* Compute the new index of the player */
				int indexActuel = p.getCaseActuelle().getIndex();
				int indexInter = indexActuel + result;
				int indexDestFinale;
				
				/* If the player is not out of the board */
				if (indexInter <= boardSize) {
					//indexInter = indexDestHypo;
					/*Puts the player in the cell and calls the function in case of a special cell*/
					
					Case interCell = this.getPlateau().getCase(indexInter);
					System.out.print("* "+p.toString() + " est à la case " +indexActuel +".");
					System.out.println(" il jette " +result + " et atteint " +indexInter +".");
					if (interCell.getJoueur() != null) {
						interCell.remplaceJoueur(p);
					} else {
						p.getCaseActuelle().retirerJoueur();
						p.setCaseActuelle(interCell);
						this.getPlateau().getCase(indexInter).setJoueur(p);
					}
					/*p.setCaseActuelle(interCell);
					this.getPlateau().getCase(indexInter).setJoueur(p);
					*/
					
					indexDestFinale = this.getPlateau().getCase(indexInter).getIndex();
					
					//System.out.println("Whatever that does");
				} else {
					indexInter = boardSize - (result - (boardSize - indexActuel));
					indexDestFinale = indexInter;
					p.setCaseActuelle(this.getPlateau().getCase(indexDestFinale));
					this.getPlateau().getCase(indexDestFinale).setJoueur(p);
					System.out.print("* "+p.toString() + " est à la case " +indexActuel +".");
					System.out.println(" il jette " +result + " et atteint " +indexInter +".");
				}
				
				int whatever = this.getPlateau().getCase(indexInter).mouvements(result);
				if (whatever > boardSize) {
					//whatever = boardSize -(result - (boardSize - whatever));
					int casesEnArriere = whatever % boardSize;
					whatever = boardSize - casesEnArriere;
					}
				Case localCase = this.getPlateau().getCase(whatever);
				p.setCaseActuelle(localCase);
				localCase.setJoueur(p);
				//this.getPlateau().getCase(indexInter).remplaceJoueur(p);
				/* gives the status of the player */
				//System.out.println("Status of player");
				
				/* Check if there is a winner */
				if (indexDestFinale == boardSize) {
					System.out.println("* "+p.toString() + " est à la case " +indexDestFinale
							+". c'est la dernière case du plateau, " + p.toString()+ " a gagné!");
					this.setPartieTerminee(true);
					break oneRound;
				}
			} else {
				p.getCaseActuelle().passeUnTour();
			}
			
		}
		
	}
	
	
	public void plusieursJeu(int max) {
		int i = 0;
		while (i < max && !this.getPartieTerminee()) {
			System.out.println("\n<-- Round " +i+" -->\n");
			this.jeuUn();
			i++;
		}
	}

}