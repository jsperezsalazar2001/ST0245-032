import java.util.Stack;
public class NotPol
{
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

}
