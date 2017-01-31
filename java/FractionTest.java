import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class FractionTest {

	@Test
	public void testGreet() {
		assertEquals("Proper fraction to decimal value conversion expected",
				0.5, new Fraction(1, 2).toDecimal(), 0);
		assertEquals("Proper addition was expected", "2/3", new Fraction(1, 3)
				.add(new Fraction(1, 3)).toString());
		assertEquals("Proper substraction was expected", "1/3", new Fraction(2,
				3).substract(new Fraction(1, 3)).toString());
		assertEquals("Proper multiplication was expected", "2/15",
				new Fraction(1, 3).multiply(new Fraction(2, 5)).toString());
		assertEquals("Proper divison was expected", "1/3", new Fraction(2, 9)
				.divide(new Fraction(2, 3)).toString());
	}
}