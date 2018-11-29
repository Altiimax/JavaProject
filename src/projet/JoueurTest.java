package projet;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class JoueurTest {

	@Test
	void test() {
	      Joueur j = new Joueur("Zidane");
	      assertEquals("Pseudo : Zidane", j.toString());
	}

}
