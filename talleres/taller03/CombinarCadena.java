/**
 *
 * La clase CombinarCadena tiene como objetivo realizar un algoritmo que saca todas las combinaciones posibles de una cadena.
 *
 * @author Yhoan Alejandro Guzmán
 * @version 1
 */
public class CombinarCadena
{
    /**
     *
     * El método combinarAux es un auxiliar del proceso 
     * @param str es la cadena a combinar
     */
    public static void combinarAux(String str) { 
        combinar(str, ""); 
    }

    /**
     *
     * El método combinar es el core del proceso, en el se busca conseguir
     * las posibles combinaciones que puede tener la cadena str 
     * @param str es la cadena a combinar
     * @param prefix cadena auxiliar donde se guarda la cadena de salida
     *
     */
    public static String combinar(String str, String prefix){
        String c="";
        if(prefix.length()==str.length()){
            System.out.println(prefix);
            return "";
        }
        for(int i=0;i<str.length();i++){
            c=prefix+str.charAt(i);
            c+=combinar(str,c);
        }
        return c;
    }

    /**
     * Método principal que ejecuta las pruebas de los métodos anteriores. 
     * @param args 
     */
    public static void main(String[] args){
        combinarAux("abc");
    }
}
