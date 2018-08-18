
/**
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion2SplitOdd10 {
    
    /**
     * Auxiliar method that solves the following statement of CodingBat - Recursion2:
       "Given an array of ints, is it possible to divide the ints into two groups, 
       so that the sum of one group is a multiple of 10, and the sum of the other 
       group is odd. Every int must be in one group or the other. Write a recursive 
       helper method that takes whatever arguments you like, and make the initial 
       call to your recursive helper from splitOdd10(). (No loops needed.)"
     */
    public boolean splitOdd10(int[] nums) {
        int cont1=0;
        int cont2=0;
        return aux(0,nums, cont1, cont2);
    }

    /**
     * Main method
     */
    public boolean aux(int start, int[] nums, int cont1, int cont2){
        return start >= nums.length ? cont1%10==0 && cont2%2==1 : aux(start+1, nums, cont1+nums[start], cont2)|| aux(start+1, nums, cont1, cont2+nums[start]);
    }
}
