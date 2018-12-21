package devoir;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class EtuTest {
	Etu toto = new Etu("vandenede", "toto",LocalDate.of(1996, 1, 2),LocalDate.of(2016, 9, 9));
	Etu luc = new Etu("dewulf", "luc", LocalDate.of(1998, 10, 26),LocalDate.of(2017, 9, 9));
	
	@Test
	void testToString() {
		assertEquals("Nom: vandenede, prénom: toto, date de naissance: 1996-01-02, date d'entrée: 2016-09-09, âge: 22\nMatricule: 2016-VT-0", toto.toString());
		assertEquals("Nom: dewulf, prénom: luc, date de naissance: 1998-10-26, date d'entrée: 2017-09-09, âge: 20\nMatricule: 2017-DL-1", luc.toString());
	}
	
	@Test
	void testmatricule() {
		assertEquals("2016-VT-1",toto.matricule(1));
		assertEquals("2017-DL-2",luc.matricule(2));
	}
	
	@Test
	void testAncien() {
		assertEquals("L'ancienneté de l'élève vaut: 2", toto.ancien());
		assertEquals("L'ancienneté de l'élève vaut: 1", luc.ancien());
	}
}