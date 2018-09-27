import java.util.Stack;
/**
*@autor Yhoan Alejandro Guzmán
*@version 1.0
*This class contains a solution for exercise 1 of taller 8 
*/
public class NotPol {
    /**
    *@param expression is the expression in polish notation to be evaluated
    *@return value of the expression 
    */
    public static int notPol  (String expression){
        String[] characters= expression.split(" ");
        Stack<String> stack= new Stack<String>();
        String aux;
        int value=0;
        for(int i=characters.length - 1; i >= 0; i--){
            stack.push(characters[i]);
        }
        int [] nums = new int[characters.length - 1];
        int index = 0;
        int current = 0;
        while(!(stack.isEmpty())){
            aux = stack.pop();
            if(isInteger(aux)){
               nums[index] = Integer.parseInt(aux);
               index++;
            }else{
                if(aux.equals("+")){
                    value = nums[current];
                    current++;
                    value += nums[current];
                    nums[current] = value;
                }
                if(aux.equals("-")){
                    value = nums[current];
                    current++;
                    value -= nums[current];
                    nums[current] = value;
                }
                if(aux.equals("*")){
                    value = nums[current];
                    current++;
                    value *= nums[current];
                    nums[current] = value;
                }
                if(aux.equals("/")){
                    value = nums[current];
                    current++;
                    value /= nums[current];
                    nums[current] = value;
                }
                if(aux.equals("%")){
                    value = nums[current];
                    current++;
                    value %= nums[current];
                    nums[current] = value;
                }
            }
        }
        return value;
    }
    //taken from: https://stackoverrun.com/es/q/1333241
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    public static void main(String[]args){
    String expression = "6 5 - 4 +";
    System.out.println(expression+" = "+notPol(expression));
    expression = "3 5 * 2 +";
    System.out.print(expression+" = "+notPol(expression));
    }
}
