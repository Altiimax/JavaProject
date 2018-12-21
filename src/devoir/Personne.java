/**
 * 
 */
package devoir;

import java.time.LocalDate;

import javax.swing.JOptionPane;

/**
 * 
 * This class represents a person
 * @author celia
 *
 */
public class Personne {
	/*
	 * the name of the person
	 */
	protected String nom;
	/*
	 * the forename of the person
	 */
	protected String prenom;
	/*
	 * either the birthday year or the year of entry
	 */
	protected int annee;
	/*
	 * either the birthday month or the month of entry
	 */
	protected int mois;
	/*
	 * either the birthday or the day of entry
	 */
	protected int jour;
	/*
	 * the birtday
	 */
	protected LocalDate ddn;
	/*
	 * the date of entry
	 */
	protected LocalDate dde;
	
	/*
	 * This constructor allows the user to create teacher from scratch
	 */
	public Personne() {
		this.nom = JOptionPane.showInputDialog("Entrez le nom");
		this.prenom = JOptionPane.showInputDialog("Entrez le prenom");
		this.jour= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre jour de naissance"));
		this.mois= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre mois de naissance"));
		this.annee= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre annee de naissance"));
		this.ddn = LocalDate.of(annee, mois, jour);
		this.jour= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre jour d'entrée"));
		this.mois= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre mois d'entrée"));
		this.annee= Integer.parseInt(JOptionPane.showInputDialog("Entrez votre annee d'entrée"));
		this.dde= LocalDate.of(annee, mois, jour);
	}
	
	/*
	 * This constructor allows the user to create teacher knowing his name, his forename, his birthday and his date of entry.
	 * @param nom the name of the person
	 * @param prenom the forename of the person
	 * @param ddn the birthday of the person
	 * @param dde the date of entry
	 */
	public Personne(String nom, String prenom, LocalDate ddn, LocalDate dde){
		this.nom = nom;
		this.prenom = prenom;
		this.ddn = ddn;
		this.dde = dde;
	}

	/*
	 * this method gives the name of the person
	 */
	public String getNom() {
		return nom;
	}

	/*
	 * this method allows the user to set the name of the person
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * this method gives the forename of the person
	 */
	public String getPrenom() {
		return prenom;
	}

	/*
	 *  this method allows the user to set the forename of the person
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/*
	 * this method gives the birthday of the person
	 */
	public LocalDate getDdn() {
		return ddn;
	}

	/*
	 *  this method allows the user to set the birthday of the person
	 */
	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}

	/*
	 * this method gives the date of entry of the person
	 */
	public LocalDate getDde() {
		return dde;
	}

	/*
	 *  this method allows the user to set the date of entry  
	 */
	public void setDde(LocalDate dde) {
		this.dde = dde;
	}
	
	/*
	 * This method gives a textual representation of the person
	 */
	public String toString() {
		return ("Nom: "+this.nom+", prénom: "+this.prenom+", date de naissance: "+this.ddn+", date d'entrée: "+this.dde+", âge: "+this.age());
	}
	
	/*
	 * this method gives the age of the person based on his birthday and on the current date
	 * @return an int representing the age of the person now
	 */
	public int age() {
  		return (LocalDate.now().getYear()-ddn.getYear());
	}
	
	/*
	 * this method gives the age of the person from a specific date 
	 * @param i the specific date 
	 * @return int representing the age of the person
	 */
	public int age(LocalDate i) {
		return (i.getYear()-ddn.getYear());
	}
}	