
/**
 * This class contains the method responsible for returning the nth value of the Fibonacci series 
 * and the main method with which the tests with values 10, 20, 100 and 1000 are executed.
 * @author Juan Sebastián Pérez Salazar
 * @version 1
 */
public class Fibonacci {
    /**
     * This method is responsible for returning the n-simo value of the Fibonacci series.
     * @param n receives the nth value that will be returned.
     * @return An integer, which is the nth value of the series. 
     */
    public static int serieFibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return serieFibonacci(n-1)+serieFibonacci(n-2);
    }
    
    /**
     * This method is in charge of making the tests of the previous method with the values of 10, 20, 100 and 1000.
     * @param args 
     */
    public static void main(String[] args){
        System.out.println("El valor número 10 de la serie de Fibonacci es: "+ serieFibonacci(10));
        System.out.println("El valor número 20 de la serie de Fibonacci es: "+ serieFibonacci(20));
        System.out.println("El valor número 100 de la serie de Fibonacci es: "+ serieFibonacci(100));
        System.out.println("El valor número 1000 de la serie de Fibonacci es: "+ serieFibonacci(1000));
    }
}
