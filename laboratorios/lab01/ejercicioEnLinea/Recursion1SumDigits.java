
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1SumDigits {
    
    public int sumDigits(int n) {
        if(n==0)return n;
        return (n%10)+sumDigits(n/10);
    }

}
