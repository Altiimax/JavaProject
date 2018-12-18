package projet;

public class CaseTrouNoir implements Case{
	protected int index;
	protected Joueur joueur; 
	protected final int CaseEnMoins = 10;

	public CaseTrouNoir(int i, Joueur joueur) {
		// TODO Auto-generated constructor stub
		this.index = i;
		this.joueur = joueur;
	}
	
	public CaseTrouNoir(int i) {
		// TODO Auto-generated constructor stub
		this.index = i;
		this.joueur = null;
	}

	@Override
	public boolean peuxPartir() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public int mouvements(int lancerDe) {
		// TODO Auto-generated method stub
		System.out.println("* Le joueur " + this.getJoueur() + " a atteint une case trou noir !");
		return this.index;
	}

	@Override
	public boolean caseOccupee() {
		// TODO Auto-generated method stub
		return this.getJoueur() != null;
	}

	@Override
	public void remplaceJoueur(Joueur joueur) {
		// TODO Auto-generated method stub
		if (this.getJoueur() != null) {
			System.out.println("* Le joueur " + this.getJoueur().toString() + " est deja dans cette case !");
			Joueur aRemplacer = this.getJoueur();
			Case aEnvoyer = joueur.getCaseActuelle();
			aRemplacer.setCaseActuelle(aEnvoyer);
			System.out.println("* Le joueur "+joueur.toString() + " vient d'arriver dans cette case et éjecte donc le joueur "
			+aRemplacer.toString() +
			" à la case : " + aEnvoyer.getIndex());
		}
	}

	@Override
	public Joueur getJoueur() {
		// TODO Auto-generated method stub
		return this.joueur;
	}

	@Override
	public void setJoueur(Joueur joueur) {
		// TODO Auto-generated method stub
		this.joueur = joueur;
	}

	@Override
	public void passeUnTour() {
	}

}
