/**
 *La clase Tablas tiene como objetivo dar solución al punto 3 del taller 5
 *
 *@autor Yhoan Alejandro Guzmán, Sebastián Pérez
 *@version 1
 **/
public class Tablas
{

    /**
     * @param n es el numero hasta el cual se quieren sacar las tablas de multiplicar
     * Este método imprime las primeras n tablas de multiplicar de n, cada una
     * desde n*1 hasta n*n.
     */
    public static void tablasMultiplicar(int n)
    {
        for(int i=1; i <= n; i++){ //c*(n+1) + c
            for(int j=1; j <= n; j++){ // (c*(n+1) + c)*n
                System.out.println(i+" * "+j+" = "+(i*j));//c*n*n
            }
            System.out.println();//cn
        }
    }

    /**
     * Este método es igual al anterior, pero con una modificación para tomar tiempos.
     */
    public static void tablasMultiplicarTiempo(int n)
    {
        long start = System.currentTimeMillis();
        for(int i=1; i <= n; i++){ //c*(largo+1) + c
            //System.out.println("Tabla de multiplicar del "+i);
            for(int j=1; j <= n; j++){ // (c*(ancho+1) + c)*largo0
                //  System.out.println(i+" * "+j+" = "+(i*j));
            }
            //System.out.println();
        }
        long fin = System.currentTimeMillis();       
        System.out.println(fin-start);
    }

    /**
     * Método main para la toma de tiempos.
     */
    public static void main(String[]args){
        for (int i = 10000; i <= 1000000; i = i + 10000){
            System.out.print("Para n = "+i+" ->");
            tablasMultiplicar(i);
        }
    }
}
