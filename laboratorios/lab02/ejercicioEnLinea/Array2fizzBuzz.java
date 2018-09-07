
/**
 * This class contains the fizzBuzz method to solve Codingbat's 
 * array 2 fizzBuzz excercise.
 * @author Yhoan Alejandro Guzmán
 */
public class Array2fizzBuzz
{
    /**
     * This method solves the following statement:
     * "This is slightly more difficult version of the famous FizzBuzz problem which 
     * is sometimes given as a first problem for job interviews. (See also: FizzBuzz Code.) 
     * Consider the series of numbers beginning at start and running up to but not including
     * end, so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new String[] 
     * array containing the string form of these numbers, except for multiples of 3, use "Fizz" 
     * instead of the number, for multiples of 5 use "Buzz", and for multiples of both 3 and 5 
     * use "FizzBuzz". In Java, String.valueOf(xxx) will make the String form of an int or other 
     * type. This version is a little more complicated than the usual version since you have to
     * allocate and index into an array instead of just printing, and we vary the start/end 
     * instead of just always doing 1..100.".
     * @param start is the initial point for the array to start
     * @param end is the final minus one point for the array to end
     * @return fbArray is the array of Strings already organized as asked in the previous statement
     */
    public String[] fizzBuzz(int start, int end) {
        int length = end - start;
        String[] fbArray = new String[length];
        for(int i = 0 ; i < length; i++){
            if(start % 3 == 0){
                if(start % 5 == 0){
                    fbArray[i] = "FizzBuzz";
                }else{
                    fbArray[i] = "Fizz";
                }
            }else if (start % 5 == 0){
                fbArray[i] = "Buzz";
            }else{
                fbArray[i] = start+"";
            }
            start++;
        }
        return fbArray;
    }
}
