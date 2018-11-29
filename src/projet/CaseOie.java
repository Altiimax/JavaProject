package projet;

public class CaseOie implements Case {
	
	protected int index;
	protected Joueur joueur;

	public CaseOie(int i) {
		this.index = i;
		this.joueur = null;
	}
	
	public CaseOie(int i, Joueur bob) {
		this.index = i;
		this.joueur = bob;
	}

	@Override
	/**
	 * @return true because it is a goose cell and thus, player entering this cell leave it immediately. 
	 */
	public boolean peuxPartir() {
		return true;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int mouvements(int lancerD�) {
		if (this.joueur != null) {
			System.out.println("La case " + this.getIndex() + " est une case Oie !");
			int prochaineCase = this.getIndex() + lancerD�;
			System.out.println("Etant donn� que le joueur " + this.getJoueur() + " est arriv� sur une case oie, il avance encore de " + lancerD� + "cases !");
			return prochaineCase;
		} else {
			return 0;
		}
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
			System.out.println("Le joueur "+joueur.toString() + " vient d'arriver dans cette case et �jecte donc le joueur "
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
	public void passeUnTour() {
	}

}
