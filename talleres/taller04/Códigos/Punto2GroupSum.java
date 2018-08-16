package taller4;

import java.util.concurrent.TimeUnit;

/**
 * Esta clase contiene el método que se encarga de encontrar si existe un subgrupo de elementos de acuerdo a lo que se pide
 * y la prueba del mismo. 
 * @author Juan Sebastián Pérez Salazar
 * @author Yohan Alejandro Guzman 
 */
public class Punto2 {
    
    /**
     * Método auxiliar que se encarga de pasar los parametros restantes al método principal. 
     * @param nums arreglo que contiene a los elementos con los cuales se va a trabajar. 
     */
    public static void sumaGrupo(int[] nums){
        System.out.println(sumaGrupo(0, nums, 15));
    }
    
    /**
     * Este es el método principal y se encarga de definir si hay un subgrupo que de la suma total de volumenes.
     * @param start indice del elemento que está analizando
     * @param nums Arreglo que posee los elemetos con los cuales se va a trabajar 
     * @param target volumen esperado 
     * @return 
     */
    private static boolean sumaGrupo(int start, int[] nums, int target) {
          if (start >= nums.length) return target == 0 ;
          else{
            try{
               TimeUnit.MILLISECONDS.sleep(10);
            }
            catch (Exception e){
            } 
            return sumaGrupo(start+1, nums, target - nums[start])|| sumaGrupo(start+1, nums, target);
          }
    }
    
    /**
     * Este método se encarga de realizar las pruebas y medir los tiempos respectivos del algoritmo.
     * @param args 
     */
    public static void main(String[] args){
        for (int i = 1; i <= 20; i++){
          int[] a = new int[i];
          for (int j = 0; j < i; j++ ){
            int numero = (int)(Math.random()*20)+1;
            a[j] = numero;
          }
          long start = System.currentTimeMillis();
            sumaGrupo(a);
          long fin = System.currentTimeMillis();       
          System.out.println(fin-start);
        }
    }
}
