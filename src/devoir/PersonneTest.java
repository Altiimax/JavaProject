package devoir;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PersonneTest {
	Personne toto, luc;
	@Before
	public void setup() {
		toto = new Personne("hassaine", "toto",LocalDate.of(1996, Month.JANUARY, 2),LocalDate.of(2016, Month.SEPTEMBER, 9));
		luc = new Personne("ujuda", "luc", LocalDate.of(1998, 10, 26),LocalDate.of(2017, 9, 9));
	}
	@Test
	void testToString() {
		toto = new Personne("hassaine", "toto",LocalDate.of(1996, Month.JANUARY, 2),LocalDate.of(2016, Month.SEPTEMBER, 9));
		luc = new Personne("ujuda", "luc", LocalDate.of(1998, 10, 26),LocalDate.of(2017, 9, 9));
		assertEquals("Nom: hassaine, prénom: toto, date de naissance: 1996-01-02, date d'entrée: 2016-09-09, âge: 22", toto.toString());
		assertEquals("Nom: ujuda, prénom: luc, date de naissance: 1998-10-26, date d'entrée: 2017-09-09, âge: 20", luc.toString());
	}

	@Test
	void testAge() {
		toto = new Etu("hassaine", "toto",LocalDate.of(1996, Month.JANUARY, 2),LocalDate.of(2016, Month.SEPTEMBER, 9));
		luc = new Etu("ujuda", "luc", LocalDate.of(1998, 10, 26),LocalDate.of(2017, 9, 9));
		assertEquals(20, luc.age());
		assertEquals(22,toto.age());
		assertEquals(20,toto.age(LocalDate.of(2016, 12, 12)));
		assertEquals(16, luc.age(LocalDate.of(2014, 12, 12)));
	}
}
