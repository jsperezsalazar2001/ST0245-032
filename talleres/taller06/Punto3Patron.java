import java.util.ArrayList;

/**
 * Esta clase contiene un método que almacena una secuencia en un ArrayList
 * @author Juan Sebastián Pérez Salazar
 */
public class Punto3Patron {
    ArrayList<Integer> lista = new ArrayList<>();
    
	/**
	 * Este método se encarga de generar el patron y almacenarlo en el ArrayList para que luego este sea imprimido. 
	 * La complejidad de este algoritmo es O(n + n^2 + n^2 + n + n)
	 * O(n^2)
	 * @param n entero que indica hasta donde se realizará la serie 
	 */
    public void patronArreglo(int n){
        
        for(int i = 1; i<=n; i++){ // O(n)
            for(int j = 1; j<=i; j++){ // O(n^2)
                lista.add(j); // O(n^2)
            }
        }
        
        for(int i=0; i<lista.size(); i++){ // O(n)
            System.out.print(lista.get(i)+" "); // O(n)
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
