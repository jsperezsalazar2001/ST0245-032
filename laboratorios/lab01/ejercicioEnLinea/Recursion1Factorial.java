
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1Factorial {
    
    /**
     * Method that solves the following statement of CodingBat - Recursion1:
       "Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. 
        Compute the result recursively (without loops)."
     */
    public int factorial(int n) {
        if(n<=0) return 1;
        return n*factorial(n-1);
    }
    
}
