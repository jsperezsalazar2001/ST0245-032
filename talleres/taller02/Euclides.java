
/**
 * Esta clase calcula el algoritmo de Euclides con el cual se halla el máximo común divisor.
 * 
 * @author (Yhoan Alejandro Guzman García) 
 * @author (Juan Sebastián Pérez Salazar)
 * @version 1
 */
public class Euclides
{
    /**
     * Este método se encarga de hallar el máximo comun divisor de dos entradas enteras. 
     * @param int p primer entero mayor que q
     * @param int q segundo entero menor que p
     * @return int returna un entero que es el máximo común divisor
     */
    public static int gcd(int p, int q){
        return q==0 ? p : gcd(q, p%q);
    }
}
