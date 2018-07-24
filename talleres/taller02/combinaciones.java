
/**
 * Esta clase sirve para mostrar en pantalla las posibles combinaciones de los caracteres de una cadena
 * 
 * @author (Yhoan Alejandro Guzmán García) 
 * @version (Juan Sebastián Pérez Salazar)
 */
public class combinaciones
{
    /**
     * @param s es la cadena a la que se le hallarán las posibles combinaciones.
     *
     * Este método llama al método aux (el cual contiene todo el proceso) y a continuación imprime el elemento "vacío", para imprimir una única vez este último.
     */
    public static void combinaciones(String s) {
        aux("",s);
        System.out.println("vacio");
    }

    /**
     * @param base, se utiliza para guardar datos en el proceso.
     * @param s es la cadena a la que se le hallarán las posibles combinaciones.
     *
     *
     * El método Aux se encarga de encontrar las posibles combinaciones en la cadena s.
     *
     */
    public static void aux(String base, String s){
        if (s.length() == 0){
            System.out.println(base);
        }
        else {
            aux(base + s.charAt(0), s.substring(1));
            aux(base, s.substring(1));
        }
    }
}

