/**
 * This class can be used to store rational numbers: numbers that can be
 * expressed as a/b where a and b are integers and b is not 0.
 * 
 * @author Sakthi Rajan Murugan
 */
public class RationalNumber {
    /** numerator */
    private int numerator;
    /** denominator */
    private int denominator;

    /**
     * Default constructor
     */
    public RationalNumber() {
        this(0, 1);
    }

    /**
     * Constructor with initial values
     * 
     * @param numerator new numerator
     * @param denominator new denominator
     */
    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    /**
     * Accessor
     * 
     * @return numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Accessor
     * 
     * @return denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * @return String representation of this Book
     */
    public String toString() {
        if (denominator == 1) {
            return "" + numerator;
        } else {
            return numerator + "/" + denominator;
        }
    }

    /**
     * @param o object to compare to this
     * @return whether o and this are equal (both RationalNumbers with same
     *         denominator and numerator)
     */
    public boolean equals(Object o) {
        if (o instanceof RationalNumber) {
            RationalNumber other = (RationalNumber) o;
            return numerator == other.numerator && denominator == other.denominator;
        } else {
            return false;
        }
    }

    /**
     * adds this and other
     * 
     * @param other rational number to add to this
     * @return the sum of this and other
     */
    public RationalNumber add(RationalNumber other) {
        return new RationalNumber(numerator * other.getDenominator() + other.getNumerator()
                        * denominator, denominator * other.getDenominator());
    }

    /**
     * this - other
     * 
     * @param other rational number to subtract from this
     * @return the difference of this and other
     */
    public RationalNumber subtract(RationalNumber other) {
        return new RationalNumber(numerator * other.getDenominator() - other.getNumerator()
                        * denominator, denominator * other.getDenominator());
    }

    /**
     * this * other
     * 
     * @param other rational number to multiply by this
     * @return the product of this and other
     */
    public RationalNumber multiply(RationalNumber other) {
        return new RationalNumber(numerator * other.getNumerator(), denominator
                        * other.getDenominator());
    }

    /**
     * this / other
     * 
     * @param other rational number to divide this by
     * @return the quotient of this and other
     */
    public RationalNumber divide(RationalNumber other) {
        return new RationalNumber(numerator * other.getDenominator(), denominator
                        * other.getNumerator());
    }

    /**
     * eliminates any common factors and ensures that denominator > 0
     */
    private void reduce() {
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    /**
     * @param x first int
     * @param y second int
     * @return the greatest common divisor of x and y
     */
    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
