package projet;

public class CaseAscenseur implements Case {
	
	protected int indexUn;
	protected int indexDeux;
	protected Joueur joueur;
	

	public CaseAscenseur(int i, int j) {
		this.indexUn = i;
		this.indexDeux = j;
		this.joueur = null;
	}
	
	public CaseAscenseur(int i, int j, Joueur joueur) {
		this.indexUn = i;
		this.indexDeux = j;
		this.joueur = joueur;
	}

	@Override
	public boolean peuxPartir() {
		return true;
	}

	@Override
	public int getIndex() {
		return this.indexUn;
	}

	@Override
	public int mouvements(int lancerDé) {
		System.out.println("Le joueur " + this.getJoueur() + " est entré dans un ascenseur !");
		System.out.println("L'ascenseur l'a emmené jusqu'à la case " + this.indexDeux);
		joueur.setCaseActuelle(indexDeux);
		return indexDeux;
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
			System.out.println("Le joueur "+joueur.toString() + "vient d'arriver dans cette case et éjecte donc le joueur "
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
	public void passeUnTour() {
	}

}
