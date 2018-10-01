package laboratorio3;

import java.util.LinkedList;

/**
 * This class contains the method that printed the output of a broken keyboard.
 * @author Juan Sebastián Pérez Salazar
 */
public class brokenKeyboard {
    
    public static LinkedList<Character> chain = new LinkedList<>();
    
    /**
     * This method stores the final result of the String in a LinkedList.
     * @param s The String
     */
    public static void broKeyboard(String s){
        int cont=0;
        boolean begin = false;
        boolean end = true;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='['){
                begin = true;
                end = false;
                cont=0;
                continue;
            }else if(s.charAt(i)==']'){
                begin = false;
                end=true;
                continue;
            }
            
            if(begin){
                chain.add(cont, s.charAt(i));
                cont++;
            }else chain.add(s.charAt(i));
        }
    }
    
    /**
     * This method prints the characters stored in the LinkedList chain.
     */
    public static void printText(){
        while(chain.size()>0){
            System.out.print(chain.removeFirst());
        }
        System.out.println();
    }
    
    /**
     * This method executes the tests of the previous methods with LinkedList.
     * @param args 
     */
    public static void main(String[] args){
        // The method is called
        broKeyboard("This_is_a_[Beiju]_text");
        printText();
        broKeyboard("[[]][][]Happy_Birthday_to_Tsinghua_University");
        printText();
        broKeyboard("asd[fgh[jkl");
        printText();
        broKeyboard("asd[fgh[jkl[");
        printText();
        broKeyboard("[[a[[d[f[[g[g[h[h[dgd[fgsfa[f");
        printText();
        broKeyboard("asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg");
        printText();
    }
    
    
}
