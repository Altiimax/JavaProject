/**
 * 
 */
package devoir;

import java.time.LocalDate;
import java.time.Month;

//import javax.swing.JOptionPane;

/**
 * @author Raphaël
 *
 */
public class Prof extends Personne{
	/*
	 * the year of entry of the professor
	 */
	private int anneeEntree = super.getDde().getYear();
	
	/*
	 * This constructor uses the basic constructor of the class "Personne"
	 */
	public Prof() {
		super();
	}
	/*
	 * this constructor creates a professor based on the person class using his name, his forename, his birthday and his date of entry
	 */
	public Prof(String nom, String prenom, LocalDate ddn, LocalDate dde) {
		super(nom, prenom, ddn, dde);
	}
	/*
	 * This method gives a textual representation of the professor
	 */
	@Override
	public String toString() {
		return (super.toString());
	}
	/*
	 * This method calculates the seniority of the professor
	 */
	public String ancien() {
		if ((anneeEntree-super.getDdn().getYear())>23) {
			return ("L'ancienneté du professeur vaut: "+(LocalDate.now().getYear()-anneeEntree));
		} else {
			if (super.age()<23) {
				return ("Le professeur n'a pas encore atteint l'âge requit pour pouvoir évaluer son ancienneté.");
			} else {
				return ("L'ancienneté du professeur vaut: "+((LocalDate.now().getYear()-anneeEntree)-(23-super.age(super.getDde()))));
			}
		}
	}
	/*
	 * this method creates a professor
	 */
	public static void main(String[] args) {
		Prof toto = new Prof("wayne", "toto",LocalDate.of(1998, Month.DECEMBER, 24),LocalDate.of(2016, Month.SEPTEMBER, 9));
		Prof bruce = new Prof("bond", "bruce",LocalDate.of(1990, Month.DECEMBER, 24),LocalDate.of(2017, Month.SEPTEMBER, 9));
		Prof jan = new Prof("potter", "harry",LocalDate.of(1990, Month.DECEMBER, 24),LocalDate.of(2011, Month.SEPTEMBER, 9));
		
		System.out.println(toto);
		System.out.println(toto.ancien());
		System.out.println(bruce.ancien());
		System.out.println(jan.ancien());
	}
}

