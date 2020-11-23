public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0){
      deno = 1;
      nume = 0;
    }

      if (deno < 0)
      {
         nume = nume * -1;
         deno = deno * -1;
      }
      numerator = nume;
      denominator = deno;
      reduce();


  }

  public double getValue(){
    double x = getNumerator();
    double y = getDenominator();
    double z = x/y;
    return z;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber recip = new RationalNumber(denominator, numerator);
    return recip;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return (numerator * other.getDenominator() == denominator * other.getNumerator());
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return numerator + "/" + denominator;
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int r = 1;
    while (r != 0)
           if (a > b){
              r = a%b;
              a = b;
              b = r;
            }
           else{
            r = b%a;
            b = r;
           }
        return a;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if (numerator != 0)
      {
         int cd = gcd (Math.abs(numerator), Math.abs(denominator));

         numerator = numerator / cd;
         denominator = denominator / cd ;
      }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber product = new RationalNumber((this.numerator * other.getNumerator()), (this.denominator * other.getDenominator()));
    return product;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber quot = new RationalNumber((this.numerator * other.getDenominator()), (this.denominator * other.getNumerator()));
    return quot;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber sum = new RationalNumber(((this.numerator* other.getDenominator()) + (other.getNumerator() *this.denominator)) , (this.denominator * other.getDenominator()));
    return sum;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber diff = new RationalNumber(((this.numerator* other.getDenominator()) - (other.getNumerator() *this.denominator)) , (this.denominator * other.getDenominator()));
    return diff;
  }
}
