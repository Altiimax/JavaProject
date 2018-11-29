package projet;

public class CasePrison implements Case {
	
	protected int index;
	protected Joueur joueur;
	protected int nbToursEnPrison;

	public int getNbToursEnPrison() {
		return nbToursEnPrison;
	}

	public void setNbToursEnPrison(int nbToursEnPrison) {
		this.nbToursEnPrison = nbToursEnPrison;
	}

	public CasePrison(int i, Joueur joueur) {
		this.index = i;
		this.joueur = joueur;
		this.nbToursEnPrison = 3;
	}
	
	public CasePrison(int i, int nbreTours) {
		this.index = i;
		this.joueur = null;
		this.nbToursEnPrison = nbreTours;
	}

	@Override
	public boolean peuxPartir() {
		if(this.getNbToursEnPrison() == 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int mouvements(int lancerD�) {
		System.out.println("Le joueur " + this.getJoueur() + "a atteint une case prison !");
		return this.index;
	}

	@Override
	public boolean caseOccupee() {
		return this.getJoueur() != null;
	}

	@Override
	public void remplaceJoueur(Joueur joueur) {
		if (this.getJoueur() != null) {
			System.out.println("Le joueur " + this.getJoueur().toString() + " est deja dans cette case !");
			Joueur aRemplacer = this.getJoueur();
			Case aEnvoyer = joueur.getCaseActuelle();
			aRemplacer.setCaseActuelle(aEnvoyer);
			System.out.println("Le joueur "+joueur.toString() + "vient d'arriver dans cette case et �jecte donc le joueur "
			+aRemplacer.toString() + " � la case : " + aEnvoyer.getIndex());
		}
	}
	
	@Override
	public Joueur getJoueur() {
		return this.joueur;
	}

	@Override
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	/**
	 * Method used to deplement the number of turns the player has to wait while in this case
	 */
	public void passeUnTour() {
		System.out.println("Le joueur " + this.getJoueur() + " doit encore attendre : "+ this.getNbToursEnPrison() + 
		" tours avant de pourvoir relancer le d�");
		this.setNbToursEnPrison(this.getNbToursEnPrison() - 1);
	}

}
