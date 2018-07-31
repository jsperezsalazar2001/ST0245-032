package taller3;


/**
 *
 * La clase PermutacionSinCombinar tiene como objetivo realizar un algoritmo que saca las permutaciones de una cadena.
 *
 * @author Yhoan Alejandro Gúzman
 * @version 1
 */

public class PermutacionSinCombinar {

    /**
     *
     * El método permutation es un auxiliar del proceso 
     * @param str es la cadena a permutar
     */
    public static void permutacion(String str) {
        permutacionAux("", str); 
    }

    /**
     *
     * El método permutationAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena str 
     * @param str es la cadena a permutar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     */
    private static void permutacionAux(String prefix, String str) {
        if(str.length() == 0){System.out.println(prefix+str);}
        if(str.length() > 0){
            for(int i = 0; i < str.length();i++){
                permutacionAux(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1,str.length()));
            }
        }
    }
    
    /**
     * Método principal que ejecuta las pruebas de los métodos anteriores. 
     * @param args 
     */
    public static void main(String[] args){
        permutacion("abc");
        System.out.println();
        permutacion("abcd");
    }
}
