/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        if (denominator == 0 && numerator != 0) {
            throw new IllegalArgumentException("denominator can not be zero!");
        }

        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 0;
        }
        else {
            this.numerator = numerator / gcd(numerator, denominator);
            this.denominator = denominator / gcd(numerator, denominator);
        }


    }

    public Rational plus(Rational b) {
        if (denominator == b.denominator) return new Rational(numerator + b.numerator, denominator);
        int newNumerator = numerator * b.denominator + b.numerator * denominator;
        int newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational minus(Rational b) {
        if (denominator == b.denominator) return new Rational(numerator - b.numerator, denominator);
        int newNumerator = numerator * b.denominator - b.numerator * denominator;
        int newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    public Rational times(Rational b) {
        return new Rational(numerator * b.numerator, denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        return new Rational(numerator / b.numerator, denominator / b.denominator);
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Rational that = (Rational) obj;
        if (this.numerator != that.numerator) return false;
        if (this.denominator != that.denominator) return false;
        return true;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 2);
        Rational b = new Rational(1, 2);
        StdOut.println(a.plus(b).equals(new Rational(1, 1)));
        StdOut.println(a.minus(b).equals(new Rational(0, 0)));
        StdOut.println(a.times(b).equals(new Rational(1, 4)));
        StdOut.println(a.divides(b).equals(new Rational(1, 1)));
    }
}
