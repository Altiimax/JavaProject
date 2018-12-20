package devoir;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class ProfTest {
	Prof toto = new Prof("wayne", "toto",LocalDate.of(1998, Month.DECEMBER, 24),LocalDate.of(2016, Month.SEPTEMBER, 9));
	Prof bruce = new Prof("bond", "bruce",LocalDate.of(1990, Month.DECEMBER, 24),LocalDate.of(2017, Month.SEPTEMBER, 9));
	Prof jan = new Prof("potter", "harry",LocalDate.of(1990, Month.DECEMBER, 24),LocalDate.of(2011, Month.SEPTEMBER, 9));
	
	@Test
	void testToString() {
		assertEquals("Nom: wayne, pr�nom: toto, date de naissance: 1998-12-24, date d'entr�e: 2016-09-09, �ge: 20", toto.toString());
	}
	
	void testAncien() {
		assertEquals("Le professeur n'a pas encore atteint l'�ge requit pour pouvoir �valuer son anciennet�.", toto.ancien());
		assertEquals("L'anciennet� du professeur vaut: 1", bruce.ancien());
		assertEquals("L'anciennet� du professeur vaut: 5", jan.ancien());
		
	}

}
