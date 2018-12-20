package modele;

public class Main {

    public static void main(String[] args) 
    {

        // Create the board we are going to play in /
        Plateau origiBoard = new PlateauBasique();

        // Initiate a game with the board /
        LeJeu aGame = new LeJeu (origiBoard);
        aGame.getPlateau().initPlateau();

        // Define the player /
        Joueur firstPlayer = new Joueur("Luc");
        Joueur secondPlayer = new Joueur("toto");
        Joueur thirdPlayer = new Joueur("arnaud");

        aGame.addJoueur(firstPlayer);
        aGame.addJoueur(secondPlayer);
        aGame.addJoueur(thirdPlayer);

        // Play 20 rounds 
        aGame.plusieursJeu(20);

    }

}