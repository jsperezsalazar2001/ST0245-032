
/**
 * This class contains the evenOdd method to solve Codingbat's 
 * array 2 evenOdd excercise.
 * @author Yhoan Alejandro Guzmán
 */
public class Array2EvenOdd
{
    /**
     * This method solves the following statement:
     * "Return an array that contains the exact same numbers as the given array, 
     * but rearranged so that all the even numbers come before all the odd numbers. 
     * Other than that, the numbers can be in any order. You may modify and return 
     * the given array, or make a new array.".
     * @param nums is an array of integers
     * @return evensOdds is an array of integers, having first the even numbers
     * and then the odd numbers
     */
    public int[] evenOdd(int[] nums) {
        int evens = 0;
        int odds = nums.length-1;
        int[] evensOdds = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {//If the element at i is even, it is added at first
                evensOdds[evens] = nums[i];
                evens++;
            }
            else {//If not, the element is added at the end, having as counters "evens" and "odds".
                evensOdds[odds] = nums[i];
                odds--;
            }
        }
        return evensOdds;
    }
}
