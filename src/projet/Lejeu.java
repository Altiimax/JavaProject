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
	
	/** Get the current board
	 * @return the board
	 */
	public Board getBoard() {
		return this.board;
	}
	
	/** Add a player in the game and assigns him to the first cell
	 * @param p is the new player to add
	 */
	public void addPlayer(Player p) {
		this.thePlayers.add(p);
		this.getBoard().getCells()[0].setPlayer(p);
	}
	
	public void playOneTime(){
		
		int boardSize = this.getBoard().getNbOfCells() - 1;
		
		/* For each player we are going to throw the dice */
		oneRound:
		for (Player p : thePlayers) {
			
			/*We check if the player can leave the cell */
			if (p.getCell().canBeLeft()) {
				
				int result = p.twoDiceThrow();
				
				/* Compute the new index of the player */
				int currentIndex = p.getCell().getIndex();
				int interIndex = currentIndex + result;
				int intermediateIndex;
				int destinationIndex;
				
				/* If the player is not out of the board */
				if (interIndex < boardSize + 1) {
					intermediateIndex = interIndex;
					destinationIndex = this.getBoard().getCell(intermediateIndex).handleMove(result);
				} else {
					intermediateIndex = boardSize - (result - (boardSize - currentIndex));
					destinationIndex = intermediateIndex;
				}
				
				/* gives the status of the player */
				System.out.print(p.toString() + " in in cell " +currentIndex +".");
				System.out.println(" He throws " +result + " and reaches the cell " +intermediateIndex +".");
				
				Cell destinationCell = this.getBoard().getCell(destinationIndex);
								
				destinationCell.welcomePlayer(p);
				p.setCell(destinationCell);
				this.getBoard().getCell(destinationIndex).setPlayer(p);
				
				/* Check if there is a winner */
				if (destinationIndex == boardSize) {
					System.out.println(p.toString() + " is in cell " +destinationIndex
							+" which is the final cell. He wins !");
					this.setGameFinished(true);
					break oneRound;
				}
			} else {
				p.getCell().letOneTurnGo();
			}
			
		}
		
	}
	
	
	public void playManyTimes(int Nmax) {
		int i = 0;
		while (i < Nmax & !this.getGameFinished()) {
			System.out.println("Round " +i);
			this.playOneTime();
			i++;
		}
	}

}
