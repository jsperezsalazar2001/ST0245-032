import java.util.ArrayList;

/**
 * Esta clase contiene un método que almacena una secuencia en un ArrayList
 * @author Juan Sebastián Pérez Salazar
 */
public class Punto3Patron {
    ArrayList<Integer> lista = new ArrayList<>();
    
	/**
	 * Este método se encarga de generar el patron y almacenarlo en el ArrayList para que luego este sea imprimido. 
	 * @param n entero que indica hasta donde se realizará la serie 
	 */
    public void patronArreglo(int n){
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                lista.add(j);
            }
        }
        
        for(int i=0; i<lista.size(); i++){
            System.out.print(lista.get(i)+" ");
        }  
        System.out.println();
    }
    
	/**
	 * Este método se encarga de ejecutar las pruebas del método anterior, el cual se ejecuta con diferentes valores de n. 
	 * @param args
	 */ 
    public static void main(String[] args){
        Punto3Patron arreglo = new Punto3Patron();
        arreglo.patronArreglo(4);
        arreglo.lista.clear();
        arreglo.patronArreglo(5);
        arreglo.lista.clear();
        arreglo.patronArreglo(6);
        arreglo.lista.clear();
    }
}
