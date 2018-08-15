
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion2GroupSum5 {
    
    public boolean groupSum5(int start, int[] nums, int target) {   
        if(start >= nums.length) return target == 0;
        if(nums[start]%5==0){
          target -= nums[start];
          if(start+1<nums.length && nums[start+1]==1) start++;
          return groupSum5(start+1, nums, target);
        }else return groupSum5(start+1, nums, target - nums[start])|| groupSum5(start+1, nums, target);
    }
    
}
