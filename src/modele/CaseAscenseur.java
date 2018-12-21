package modele;
/**
 * this class makes a player going from a specific cell to another and same in the other way
 * @author celia, Kevin, Arnaud
 *
 */
public class CaseAscenseur implements Case {
	// current index of the player
	protected int index;
	// the player concerned by this case
	protected Joueur joueur;
	
	/*
	 * constructor of the CaseAscenceur knowing its index / 
	 */
	public CaseAscenseur(int i) {
		this.index = i;
		this.joueur = null;
	}
	
	public CaseAscenseur(int i, Joueur joueur) {
		this.index = i;
		this.joueur = joueur;
	}

	@Override
	public boolean peuxPartir() {
		return true;
	}
	

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public int mouvements(int lancerDe) {
		if(this.joueur != null) {
			int indexDeux = 0;
			System.out.println("* Le joueur " + this.getJoueur() + " est entré dans un ascenseur !");
			if(this.getIndex() == 8) { indexDeux = 16;}
			if(this.getIndex() == 16) { indexDeux = 8;}
			if(this.getIndex() == 45) { indexDeux = 62;}
			if(this.getIndex() == 62) { indexDeux = 45;}
			System.out.println("* L'ascenseur l'a emmené jusqu'à la case " + indexDeux);
			return indexDeux;
		} else {
			return this.getIndex();
		}
	}

	@Override
	public boolean caseOccupee() {
		return this.getJoueur() != null;
	}

	@Override
	public void remplaceJoueur(Joueur joueur) {
		if (this.getJoueur() != null && this.getJoueur().getPseudo() != joueur.getPseudo()) {
			System.out.println("* Le joueur " + this.getJoueur().toString() + " est deja dans cette case !");
			Joueur aRemplacer = this.getJoueur();
			Case remplacer = this.getJoueur().getCaseActuelle();
			Case aEnvoyer = joueur.getCaseActuelle();
			aRemplacer.setCaseActuelle(aEnvoyer);
			System.out.println("* Le joueur "+joueur.toString() + " vient d'arriver dans cette case et éjecte donc le joueur "
			+aRemplacer.toString() + " à la case : " + aEnvoyer.getIndex());
			this.setJoueur(joueur);
			joueur.setCaseActuelle(remplacer);
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
	
	public void retirerJoueur() {
		this.joueur = null;
	}
	

}
