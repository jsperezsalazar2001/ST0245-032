
/**
 * Se realiza paso a paso la torre de Hannoi.
 * 
 * @author Juan Sebastián Pérez Salazar
 * @version 1
 */
public class TorresDeHanoi
{
   /**
    *
    * El método torresDeHannoi es un auxiliar del proceso 
    * @param n numero de discos
    * 
    */  
    
    public static void torresDeHanoi(int n) {
        torresDeHanoiAux(n, 1, 2, 3);
    }

    /**
    *
    * El método torresDeHannoi es un auxiliar del proceso 
    * @param n numero de discos
    * @param origen la torre número uno donde se posicionan todos los discos inicialmente
    * @param destino la torre donde deben posicionarse todos los discos terminado el proceso
    * @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
    * 
    */
    private static void torresDeHanoiAux(int n, int origen, int intermedio, int destino) {
        if(n==1){
            System.out.println("Mover el disco "+n+" de "+origen+" a "+destino);
        }else{
            torresDeHanoiAux(n-1, origen, destino, intermedio);
            System.out.println("Mover el disco "+n+" de "+origen+" a "+destino);
            torresDeHanoiAux(n-1, intermedio, origen, destino);
        }
    }
}
