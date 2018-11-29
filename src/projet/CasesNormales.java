package projet;

public class CasesNormales implements Case {
	
	protected int index;
	protected Joueur joueur;

	public CasesNormales(int i) {
		this.index = i;
		this.joueur = null;
	}
	
	public CasesNormales(int i, Joueur bob) {
		this.index = i;
		this.joueur = bob;
	}

	@Override
	/**
	 * @return true because it is a normal cell, therefore, no special treatments for player on this cell
	 */
	public boolean peuxPartir() {
		return true;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	/**
	 * @return the index since this is a normal cell, we don't need the number of the dice throw for anything.
	 */
	public int mouvements(int lancerDe) {
		return this.getIndex();
	}

	@Override
	public boolean caseOccupee() {
		return this.getJoueur() != null;
	}

	@Override
	public void remplaceJoueur(Joueur joueur) {
		if (this.getJoueur() != null) {
			System.out.println("* Le joueur " + this.getJoueur().toString() + " est deja dans cette case !");
			Joueur aRemplacer = this.getJoueur();
			Case aEnvoyer = joueur.getCaseActuelle();
			aRemplacer.setCaseActuelle(aEnvoyer);
			System.out.println("* Le joueur "+joueur.toString() + " vient d'arriver dans cette case et éjecte donc le joueur "
			+aRemplacer.toString() + " à la case : " + aEnvoyer.getIndex());
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
	 * this method doesn't trigger itself on a normal cell.
	 */
	public void passeUnTour() {
	}

}
