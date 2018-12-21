/**
 * 
 */
package devoir;

import java.time.LocalDate;
import java.time.Month;

//import javax.swing.JOptionPane;

/**
 * this class represents a student
 * @author kevin
 *
 */

public class Etu extends Personne{
	/*
	 * the registration number of the student
	 */
	private static int numeroMatricule = 0;
	/*
	 * the registration number of the student
	 */
	private String matri;
	
	/*
	 * This constructor allows the user to create teacher from scratch
	 */
	public Etu() {
		super();
		this.matricule(numeroMatricule);
		numeroMatricule++;
	}
	
	/*
	 * This constructor allows the user to create teacher knowing his name, his forename, his birthday and his date of entry.
	 * @param nom the name of the person
	 * @param ddn the birthday of the person
	 * @param dde the date of entry
	 */
	public Etu(String nom, String prenom, LocalDate ddn, LocalDate dde) {
		super(nom, prenom, ddn, dde);
		this.matricule(numeroMatricule);
		numeroMatricule++;
	}
	
	

	public static int getNumeroMatricule() {
		return numeroMatricule;
	}

	public static void setNumeroMatricule(int numeroMatricule) {
		Etu.numeroMatricule = numeroMatricule;
	}

	public String getMatri() {
		return matri;
	}

	public void setMatri(String matri) {
		this.matri = matri;
	}

	@Override
	/*
	 * This method gives a textual representation of the student
	 */
	public String toString() {
		return (super.toString()+"\nMatricule: "+this.matri);
	}
	
	/*
	 * this method gives the registration number of the student based on the date of entry, the first letter of his name and forename and the number of student currently registred
	 */
	public String matricule(int mat) {
		// TODO Auto-generated method stub
		matri = Integer.toString(super.getDde().getYear())+"-"+super.getNom().substring(0, 1).toUpperCase()+super.getPrenom().substring(0, 1).toUpperCase()+"-"+Integer.toString(mat);
		return matri;
	}

	/*
	 * this method gives the years spent in the school
	 */
	public String ancien() {
		return ("L'ancienneté de l'élève vaut: "+(LocalDate.now().getYear()-super.getDde().getYear()));
	}
	
	/*
	 * this method allows the user to create an actual student
	 */
	public static void main(String[] args) {
		Etu toto = new Etu("vandenede", "kevin",LocalDate.of(1996, Month.JANUARY, 2),LocalDate.of(2017, Month.SEPTEMBER, 9));
		Etu luc = new Etu("bruce", "luc",LocalDate.of(1998, Month.DECEMBER, 24),LocalDate.of(2015, Month.SEPTEMBER, 9));
		Etu celia = new Etu("bruce", "celia",LocalDate.of(2000, Month.DECEMBER, 24),LocalDate.of(2016, Month.SEPTEMBER, 9));
		
		System.out.println(toto);
		System.out.println(toto.ancien());
		System.out.println(toto.age());
		System.out.println(luc);
		System.out.println(celia);
	}
	
}
