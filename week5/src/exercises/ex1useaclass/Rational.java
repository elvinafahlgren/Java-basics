package exercises.ex1useaclass;

import static java.lang.Math.abs;

/*
 *    A class representing a rational number
 *
 *    NOTE: No IO here, this is just the logical concept.
 *
 *    Test the class by running Ex1TestRational.
 *
 * See:
 * - useaclass/
 * - UseAMap
 */

public class Rational{

    private final int num;    // rational =  num / denom
    private final int denom;

    public Rational(int num){
        // If no denum
        this.num = num;
        this.denom = 1;
    }
    public Rational(int num, int denom){
        this.num = num / gcd(num, denom);
        this.denom = denom / gcd(num, denom);
    }

    public Rational(Rational r){
        this.num = r.getNum();
        this.denom = r.getDenom();
    }

    // Greatest common divisor method
    public static int gcd(int num, int denom){
        if(num == 0)
            return denom;
        // If both num and denom is less than 0, we want negative gcd
        if(num < 0 && denom < 0)
            return gcd(denom % num, num);
        // Denom should always be positive, therefore make gdc negative so we get positive outcome
        else if(denom < 0)
            return -1 * gcd(abs(denom) % num, num);
        return gcd(denom % abs(num), abs(num));
    }

    public int getNum(){
        return this.num;
    }

    public int getDenom(){
        return this.denom;
    }

    public Rational add(Rational r){
        // Denominator of final fraction obtained
        // finding LCM of den1 and den2
        // LCM * GCD = a * b
        int newDenom = (this.denom * r.getDenom()) / gcd(this.denom, r.getDenom());

        // Changing the fractions to have same denominator
        // Numerator of the final fraction obtained
        int newNum = this.num * (newDenom / this.getDenom()) + r.getNum() * (newDenom / r.getDenom());

        return new Rational(newNum, newDenom);
    }

    public Rational sub(Rational r){
        int newDenom = (this.denom * r.getDenom()) / gcd(this.denom, r.getDenom());
        int newNum = this.num * (newDenom / this.getDenom()) - r.getNum() * (newDenom / r.getDenom());

        return new Rational(newNum, newDenom);
    }

    public Rational mul(Rational r){
        int newDenum = this.denom * r.getDenom();
        int newNum = this.num * r.getNum();

        return new Rational(newNum, newDenum);
    }
    public Rational div(Rational r){
        int newDenum = this.denom / r.getDenom();
        int newNum = this.num / r.getNum();

        return new Rational(newNum, newDenum);
    }

    @Override
    public boolean equals(Object o){
        Rational r = (Rational) o;
        if(r.getNum() == this.num && r.getDenom() == this.denom)
            return true;
        return false;
    }

    // Standard hash implementation
    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + this.num;
        hash = 31 * hash + this.denom;
        return hash;
    }


    public boolean lessThan(Rational r){
        if(r.getNum() >= this.num || r.getDenom() >= this.denom) //TODO VET INTE RIKTIGT HUR DET SKA VARA...
            return false;
        return true;
    }

    public double toDouble(){
        return (double) this.num / this.denom;
    }

    @Override
    public String toString(){
        return this.num + " / " + this.denom;
    }

}

