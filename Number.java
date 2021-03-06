public abstract class Number{
  public abstract double getValue();

  /*return 0 when this Number equals the other Number
  return a negative value when this Number is smaller than the other Number
  return a positive value when this Number is larger than the other Number
  */
  public int compareTo(Number other){
    int x = 0;
    if (this.getValue() > other.getValue()){
      x = 1;
    }
    if (this.getValue() < other.getValue()){
      x = -1;
    }
    return x;
  }

  /*
  *Return true when the % difference of the values
  *are within 0.00001 of eachother.
  *Special case: if one is exactly zero, the other must be exactly zero.
  */
  public boolean equals(Number other){
    boolean x = false;
    if ( this.getValue() == 0 || other.getValue() == 0){
      x = (this.getValue() == other.getValue());
    }
    else{
      x = ((Math.abs((this.getValue()-other.getValue())/other.getValue()) * 10000) <= 0.00001);
    }
    return x;
}
}
