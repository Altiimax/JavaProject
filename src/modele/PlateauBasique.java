package modele;
/**
 * this class store all the special power of the cells
 */
public class PlateauBasique extends Plateau {
	/*
	 * Creates a board with 64 cells.
	 */
	public PlateauBasique() {
		super(64);
	}
	
	public void initPlateau() {
		Case[] casesJeu = new Case[64];
		casesJeu[0] = new CaseDepart(0);
		
		for (int i=1; i<64; i++) {
			casesJeu [i] = new CasesNormales(i);
		}
		/**
		 * 
		 *
		casesJeu[8] = new CaseAscenseur(8);
		casesJeu[16] = new CaseAscenseur(16);
		*/
		casesJeu[21] = new CasePrison(21);
		/**
		casesJeu[32] = new CaseTrouNoir(32);
		*/
		casesJeu[38] = new CasePrison(38);
		/**
		casesJeu[45] = new CaseAscenseur(45);
		casesJeu[62] = new CaseAscenseur(62);
		
		int[] casesOies = {7, 17, 23, 28, 41, 50, 59};
		
		for(int i : casesOies) {
			casesJeu [i] = new CaseOie(i);
		}
		*/
		
		this.setCases(casesJeu);
	}
}
