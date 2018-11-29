package projet;

import projet.Case;
/**
 * @author celia
 * groupe 15, 2TL2
 *
 */
public class Joueur {
    /**
     * the place where the player stands on the tray
     */
    protected Case caseActuelle;
    /**
     * the name of the player
     */
    protected String pseudo;

    public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
     * This constructor allows the user to create a player knowing a number that will 
     * describe his pawn
     * @param nbr number representing the player
     */
    public Joueur (Case nbr) {
        super();
        this.caseActuelle = nbr;
    }

    /**
     * This constructor allows the user to create a player knowing his name, forename, pseudo 
     * and a number which will stand for the pawn
     * @param nom name of the player
     * @param prenom forename of the player
     * @param nbr number representing the player
     */
    public Joueur (String pseudo, Case nbr) {
        this.pseudo = pseudo;
        this.caseActuelle = nbr;
    }
    /**  A player with no current cell (== null)
     * @param name the name of this player
     * 
    */
    public Joueur (String pseudo){
        this.pseudo = pseudo;
        this.caseActuelle = null;
    }

    public Case getCaseActuelle() {
        return caseActuelle;
    }

    public void setCaseActuelle(Case caseActuelle) {
        this.caseActuelle = caseActuelle;
    }

    public String toString() {
        return (pseudo);
    }

    /**result of rolling two dices
      * @return random result of a 2 dices throw
    */

    public int lanceDé() {
        int result = (((int) (Math.random()*(6 - 1))) + 1) + (((int) (Math.random()*(6 - 1))) + 1);
        return result;
    }
}