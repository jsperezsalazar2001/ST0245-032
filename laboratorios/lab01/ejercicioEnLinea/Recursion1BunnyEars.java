
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1BunnyEars {
    
    public int bunnyEars(int bunnies) {
        if(bunnies==0) return bunnies; 
        return 2+bunnyEars(bunnies-1);
    }
}
