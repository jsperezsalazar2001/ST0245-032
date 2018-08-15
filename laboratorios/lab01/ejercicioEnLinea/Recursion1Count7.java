
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1Count7 {
    
    public int count7(int n) {
        if(n==0) return 0;
        return (n%10==7)? 1+count7(n/10) : count7(n/10); 
    }

}
