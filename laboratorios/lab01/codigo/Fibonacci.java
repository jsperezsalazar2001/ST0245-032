
/**
 * Esta clase contiene el método encargado de retornar el valor enésimo de la serie Fibonacci y el método main
 * con el cual se ejecutan las pruebas con los valores 10, 20, 100 y 1000.
 * @author Juan Sebastián Pérez Salazar
 * @author Yhoan Alejandro Gúzman 
 * @version 1
 */
public class Fibonacci {
    /**
     * Este método se encarga de retornar el valor n-simo de la serie de Fibonacci.
     * @param n recibe el valor enésimo que se retornará.
     * @return Un entero, el cual es el valor enésimo de la serie. 
     */
    public static int serieFibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return serieFibonacci(n-1)+serieFibonacci(n-2);
    }
    
    /**
     * Este método se encarga de hacer las pruebas del método anterior con los valores de 10, 20, 100 y 1000.
     * @param args 
     */
    public static void main(String[] args){
        System.out.println("El valor número 10 de la serie de Fibonacci es: "+ serieFibonacci(10));
        System.out.println("El valor número 20 de la serie de Fibonacci es: "+ serieFibonacci(20));
        System.out.println("El valor número 100 de la serie de Fibonacci es: "+ serieFibonacci(100));
        System.out.println("El valor número 1000 de la serie de Fibonacci es: "+ serieFibonacci(1000));
    }
}
