/**
 * La clase Contador tiene la intención de representar un contador.
 * 
 * @author (Juan Sebastián Pérez Salazar)
 * @author (Yhoan Alejandro Guzman)
 * @version 17 de julio, 2018
 */

public class Contador {
    
    private int cuenta;
    private final String id;


    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Contador(int cuenta, String id) {
        this.cuenta=cuenta; 
        this.id = id;
    }

    /**
     * El método incrementar incrementa el contador en la cantidad que el usuario selecciona.
     *
     */
    public void incrementar(int cantidad) {
        cuenta += cantidad; 
    }

    /**
     * El método decrementar decrementa el contador en la cantidad que el usuario selecciona.
     *
     */
    public void decrementar(int cantidad) {
        if(cuenta-cantidad>0) cuenta -= cantidad;
        else System.out.println("No se decrementó porque la cantidad supera la cuenta");
    }

    /**
     * El método incrementos nos muestra en que valor se encuentra la cuenta actualmente.
     * @return el numero actual de la cuenta
     */
    public int incrementos() {
        return this.cuenta; 
    }

    
    /**
    * toString se encargará de convertir el contador en un tipo cadena
    * para su posterior visualización.
    *
    * @return una cadena que contiene el id del contador y su cuenta
    */
    public String toString() {
        return "ID: "+ this.id +"\n"+
               "Cuenta: "+this.cuenta;
    }
}
