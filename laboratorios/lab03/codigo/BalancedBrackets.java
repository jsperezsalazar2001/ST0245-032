import java.util.Scanner;
import java.util.Stack;
import java.util.InputMismatchException;
/**
 * This class is a solution for point 2.3 of lab 3.
 * @author Yhoan Alejandro Guzmán
 */
public class BalancedBrackets
{

    /**
     * This method is an auxiliar of the balance method.
     * @param n number of strings to be given.
     */
    public void balanceAux(int n){
        Scanner in = new Scanner(System.in);
        boolean[] yesNo = new boolean[n];
        for(int i = 0; i < n; i++){
            System.out.println("Input the string of brackets");
            String str = in.nextLine();
            yesNo[i] = balance(str);
        }
        for(int i = 0; i < n; i++){
            if(yesNo[i]){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    /**
     * This method determines whether the string is balanced or not.
     * @param str is the string to be analized.  
     * @return true if the string is balanced, false if not.
     */
    public boolean balance(String str){
        String[] strArray = str.split("");
        Stack brackets = new Stack();
        boolean isBalanced = true;
        for(int i = 0; i < strArray.length; i++){
            if((strArray[i].equals("(")) || (strArray[i].equals("{")) || (strArray[i].equals("["))){
                brackets.push(strArray[i]);
            }else if(strArray[i].equals(")") || strArray[i].equals("}") || strArray[i].equals("]")){
                if(!brackets.empty()){
                    String openBracket = (String)brackets.pop();
                    if(strArray[i].equals(")")){
                        if(!openBracket.equals("(")){
                            isBalanced = false;
                            break;
                        }
                    }
                    if(strArray[i].equals("}")){
                        if(!openBracket.equals("{")){
                            isBalanced = false;
                            break;
                        }
                    }
                    if(strArray[i].equals("]")){
                        if(!openBracket.equals("[")){
                            isBalanced = false;
                            break;
                        }
                    }            
                }else{
                    isBalanced = false;
                    break;
                }
            }
        }
        if(!brackets.empty()){
            isBalanced = false; 
        }       
        return isBalanced;
    }

    /**
     * Main method for testing this class.
     */
    public static void main(String [] args){
        BalancedBrackets balance = new BalancedBrackets();
        Scanner in = new Scanner(System.in);
        System.out.println("Input the amount of brackets");
        balance.balanceAux(in.nextInt());
    }
}
