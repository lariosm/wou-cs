
/**
 * This program uses recursion to determine whether an
 * integer is prime.
 * 
 * @author Manuel Larios 
 * @version CS162 Lab #8, 11/18/2016
 */
public class PrimeFinder
{
    //No fields needed here.
    
    /**
     * Constructor for objects of class PrimeFinder
     * @param The integer we want to check against.
     */
    public PrimeFinder(int n)
    {
        prime(n);
    }
    
    /**
     * A "preliminary" checker to see if the integer value is
     * a prime number
     * @param the value we want to check.
     * @return whether the value is a prime number.
     */
    public boolean prime(int n) {
        if(n == 1) {
            return false; //then it is not prime
        }
        else {
            return primeHelper(n, n - 1);  //We call on primeHelper() to help out.
        }
    }
    
    /**
     * 
     */
    public boolean betterPrime(int n) {
        //Nothing here yet...
    }
    
    /**
     * Here, we try more elaborate ways to check if the integer
     * value is a prime number
     * @param 
     */
    private boolean primeHelper(int n, int testDivisor) {
        if(testDivisor < 2) {
            return true; //If any divisor
        }
        else if(n % testDivisor == 0) {
            return false;
        }
        else {
            return primeHelper(n, testDivisor - 1);
        }
    }
    
    /**
     * 
     */
    public void generatePrimes() {
        //Nothing here yet...
    }
}
