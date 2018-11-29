package projet;

public class Main {

    public static void main(String[] args) 
    {

        // Create the board we are going to play in /
        Plateau origiBoard = new PlateauBasique();

        // Initiate a game with the board /
        LeJeu aGame = new LeJeu (origiBoard);
        aGame.getPlateau().initPlateau();

        // Define the player /
        Joueur firstPlayer = new Joueur("Zidane");
        Joueur secondPlayer = new Joueur("Ronaldo");
        Joueur thirdPlayer = new Joueur("Beckam");

        aGame.addJoueur(firstPlayer);
        aGame.addJoueur(secondPlayer);
        aGame.addJoueur(thirdPlayer);

        // Play 20 rounds 
        aGame.playManyTimes(20);

    }

}