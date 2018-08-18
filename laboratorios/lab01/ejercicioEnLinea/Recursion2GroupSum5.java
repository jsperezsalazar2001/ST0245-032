
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion2GroupSum5 {
    
    /**
    * Method that solves the following statement of CodingBat - Recursion2:
      "Given an array of ints, is it possible to choose a group of some of the ints, 
      such that the group sums to the given target with these additional constraints: 
      all multiples of 5 in the array must be included in the group. If the value immediately 
      following a multiple of 5 is 1, it must not be chosen. (No loops needed.)"
    */ 
    public boolean groupSum5(int start, int[] nums, int target) {   
        if(start >= nums.length) return target == 0;
        if(nums[start]%5==0){
          target -= nums[start];
          if(start+1<nums.length && nums[start+1]==1) start++;
          return groupSum5(start+1, nums, target);
        }else return groupSum5(start+1, nums, target - nums[start])|| groupSum5(start+1, nums, target);
    }
    
}
