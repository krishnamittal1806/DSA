class Solution {
    public double myPow(double x, int n) {
        if( n > 0){
          return calculate( x , (long) n );
        }
        else return calculate( 1/x , - (long) n);
        
    }
    private double calculate( double x , long n){
        if( n == 0) return 1;
        if( n%2 == 0) return calculate( x * x , n/2);
         else return x * calculate(x*x , n/2);
    }
}