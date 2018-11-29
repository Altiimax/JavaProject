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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean caseOccupee() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remplaceJoueur(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Joueur getJoueur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJoueur(Joueur joueur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void passeUnTour() {
		// TODO Auto-generated method stub
		
	}

}
