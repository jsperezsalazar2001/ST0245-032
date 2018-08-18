
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion2SplitArray {
    
    /**
    * Method that solves the following statement of CodingBat - Recursion2:
     "Given an array of ints, is it possible to divide the ints into two groups, 
     so that the sums of the two groups are the same. Every int must be in one 
     group or the other. Write a recursive helper method that takes whatever 
     arguments you like, and make the initial call to your recursive helper from 
     splitArray(). (No loops needed.)"
    */
    public boolean splitArray(int[] nums) {
        int cont1=0;
        int cont2=0;
        return aux(0,nums, cont1, cont2);
    }

    public boolean aux(int start, int[] nums, int cont1, int cont2){
        return start >= nums.length ? cont1==cont2 : aux(start+1, nums, cont1+nums[start], cont2)|| aux(start+1, nums, cont1, cont2+nums[start]);
    }

}
