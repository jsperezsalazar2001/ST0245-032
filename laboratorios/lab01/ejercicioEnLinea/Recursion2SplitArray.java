
/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Recursion2SplitArray {
    
    public boolean splitArray(int[] nums) {
        int cont1=0;
        int cont2=0;
        return aux(0,nums, cont1, cont2);
    }

    public boolean aux(int start, int[] nums, int cont1, int cont2){
        return start >= nums.length ? cont1==cont2 : aux(start+1, nums, cont1+nums[start], cont2)|| aux(start+1, nums, cont1, cont2+nums[start]);
    }

}
