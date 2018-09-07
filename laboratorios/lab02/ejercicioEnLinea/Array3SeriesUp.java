
/**
 * This class contains the seriesUp method to solve Codingbat's 
 * array 3 seriesUp excercise.
 * @author Yhoan Alejandro Guzmán
 */
public class Array3SeriesUp
{
    /**
     * This method solves the following statement:
     * "Given n>=0, create an array with the pattern {1,1, 2,1, 2, 3,... 1, 2, 3 .. n} (spaces added to show the grouping).
     * Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.".
     * @param n is the final number in the pattern asked.
     * @return array contains the pattern of numbers following the previous statement.
     */
    public int[] seriesUp(int n) {
        //The length of the array is given by the sum of the first n numbers from 1 to n, because
        //when we have an array like: [1],1,[2],1,2,[3],1,2,3,[4], the numbers between [] are the
        //number of positions+1 ocuppied by the numbers without [] before them, so if we sum them all, we get
        //the length of the array, wich is the same as summing the first n numbers from 1 to n.
        //So we can use the next formula, as stated in the problem:
        int[] array = new int[n*(n + 1)/2];
        int count = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                array[count] = j;
                count++;
            }
        }
        return array;
    }
}
