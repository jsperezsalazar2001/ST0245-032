import java.util.concurrent.TimeUnit;
/**
 * La clase Fibonacci tiene la intención de resolver el punto 3 del taller número 4.
 *
 * @author Yhoan Alejandro Guzmán, Sebastián Pérez
 * @version 1
 */

public class Fibonacci2 {

    /**
     * @param n es el n-ésimo termino que se quiere calcular de la sucesión de fibonacci.
     * Este método hace lo cálculos necesarios para obtener este n-ésimo término
     */
    public  int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        try{
            TimeUnit.SECONDS.sleep(1); //Para obtener el tiempo de ejecución
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Este método es el main y sirve para ejecutar y probar el método fibonacci
     */
    public static void main(String[]args){
        Fibonacci2 prueba = new Fibonacci2();
        for(int i = 0; i < 15; i++ ){
            long start = System.currentTimeMillis();
            prueba.fibonacci(i);
            long fin = System.currentTimeMillis();
            System.out.println(("Tiempo para n = "+i)+" => "+(fin-start));
        }
    }
}
