package modele;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) 
    {

        // Create the board we are going to play in /
        Plateau origiBoard = new PlateauBasique();

        // Initiate a game with the board /
        LeJeu aGame = new LeJeu (origiBoard);
        aGame.getPlateau().initPlateau();

        // Define the player /
        int i = Integer.parseInt(JOptionPane.showInputDialog("Entrez le nombre de joueurs : "));
        for (int j=0; j<i; j++ ) {
        Joueur firstPlayer = new Joueur();

        aGame.addJoueur(firstPlayer);

        }
        // Play 20 rounds 
        aGame.plusieursJeu(25);

    }

}