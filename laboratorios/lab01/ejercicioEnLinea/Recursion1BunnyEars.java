
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion1BunnyEars {
    
    /**
     * Method that solves the following statement of CodingBat - Recursion1:
       "We have a number of bunnies and each bunny has two big floppy ears. 
        We want to compute the total number of ears across all the bunnies 
        recursively (without loops or multiplication)."
     */   
    public int bunnyEars(int bunnies) {
        if(bunnies==0) return bunnies; 
        return 2+bunnyEars(bunnies-1);
    }
}
