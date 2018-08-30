import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase contiene un método que agrega elementos a un ArrayList hasta que el usuario ingrese -1.
 * @author Juan Sebastián Pérez Salazar, Yhoan Alejandro Guzmán
 */
public class Punto2ArrayList {
    ArrayList<Integer> listaIndefinida = new ArrayList<>();
    
    /**
     * Este método me recibe valores y los alamacena de manera inversa hasta que el usuario ingrese -1
     * La complejidad de este algoritmo es T(n) = C_1 + n + n^2 + n + n + C_2 + n + n
     * La notación BigO es:
     * O(C_1 + n + n^2 + n + n + C_2 + n + n)
     * O(n^2) por regla de la suma
     */
    public void recibirEImprimir(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite un entero o -1 para finalizar");
        int num = sc.nextInt();
        while(num != -1){ // C_1 + n
            listaIndefinida.add(0, num); // n*n
            System.out.println("Digite un entero o -1 para finalizar"); // n
            num = sc.nextInt(); // n
        }
        
        for(int i = 0; i<listaIndefinida.size(); i++){ // C_2 + n
            System.out.print(listaIndefinida.get(i) + " "); // n
        }
    }
    
    /**
     * Este método se encarga de realizar las pruebas del método anterior. 
     * @param args 
     */
    public static void main(String[] args){
        Punto2ArrayList lista = new Punto2ArrayList();
        lista.recibirEImprimir();
    }
}
