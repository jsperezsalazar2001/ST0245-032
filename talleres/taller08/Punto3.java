package taller8;

import java.util.Stack;

/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class Punto3 {
    public static Stack<Integer> stack = new Stack<>();
    
    public static void invertir(){
        Stack<Integer> s = new Stack<>();
        
        while(stack.size()>0){
            s.push(stack.pop());
        }
        
        int i=0;
        while(i<s.size()){
            stack.push(s.get(i));
            i++;
        }
    }
    
    public static void imprimir(){
        for(int i=stack.size()-1; i>=0; i--){
            System.out.println(stack.get(i));
        }
    }
    
    public static void main(String[] args){
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        imprimir();
        invertir();
        imprimir();
    }
}
