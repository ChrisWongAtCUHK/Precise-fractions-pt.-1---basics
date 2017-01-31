import java.math.BigInteger;

public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		String result = (numerator * denominator) < 0 ? "-" : ""; // sign
		// turn to positive if necessary
		numerator = numerator < 0 ? numerator * -1 : numerator;
		denominator = denominator < 0 ? denominator * -1 : denominator;
		
		int wholes = numerator / denominator;
		if (wholes > 0) {
			result += wholes + " ";
		}

		numerator = numerator % denominator;
		int gcd = gcd(numerator, denominator);
		if(numerator == 0){
			// it is integer
			result = result.trim();
		} else {
			result += numerator / gcd + "/" + denominator / gcd;
		}
		return result.length() == 0 ? "0" : result;
	}

	public double toDecimal() {
		return (double) numerator / denominator;
	}

	public Fraction add(int value) {
		return new Fraction(this.numerator + value * this.denominator,
				this.denominator);
	}

	public Fraction add(Fraction value) {
		// get the gcd of 2 denominators
		int gcd = gcd(this.denominator, value.denominator);

		// calculate the 2 numerators and add them
		int sum = this.numerator * value.denominator / gcd + value.numerator
				* this.denominator / gcd;
		return new Fraction(sum, this.denominator * value.denominator / gcd);
	}

	public Fraction substract(int value) {
		return new Fraction(this.numerator - value * this.denominator,
				this.denominator);
	}

	public Fraction substract(Fraction value) {
		// get the gcd of 2 denominators
		int gcd = gcd(this.denominator, value.denominator);

		// calculate the 2 numerators and substract them
		int difference = this.numerator * value.denominator / gcd
				- value.numerator * this.denominator / gcd;
		return new Fraction(difference, this.denominator * value.denominator
				/ gcd);
	}

	public Fraction multiply(int value) {
		return new Fraction(this.numerator * value, this.denominator);
	}

	public Fraction multiply(Fraction value) {
		return new Fraction(this.numerator * value.numerator, this.denominator
				* value.denominator);
	}

	public Fraction divide(int value) {
		return new Fraction(this.numerator, this.denominator * value);
	}

	public Fraction divide(Fraction value) {
		return new Fraction(this.numerator * value.denominator,
				this.denominator * value.numerator);
	}

	private int gcd(int i1, int i2) {
		BigInteger d1 = BigInteger.valueOf(i1);
		BigInteger d2 = BigInteger.valueOf(i2);
		return d1.gcd(d2).intValue();
	}
}