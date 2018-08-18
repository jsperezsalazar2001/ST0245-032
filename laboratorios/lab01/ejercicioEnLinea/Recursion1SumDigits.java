
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1SumDigits {
    
    /**
     * Method that solves the following statement of CodingBat - Recursion1:
       "Given a non-negative int n, return the sum of its digits recursively (no loops). 
       Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 
       removes the rightmost digit (126 / 10 is 12)."
     */
    public int sumDigits(int n) {
        if(n==0)return n;
        return (n%10)+sumDigits(n/10);
    }

}
