package taller9;

import java.util.HashMap;

/**
 * Esta clase contiene los metodos y las aplicaciones de los ejercicios 2 a 4
 * del taller 9. 
 * @author Juan Sebastián Pérez Salazar
 */
public class Taller9 {

    
    /**
     * En este método se realizan los puntos 2 y 3. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        
        // Punto 2 del taller 9
        
        hm.put("Google", "Estados Unidos");
        hm.put("La locura", "Colombia");
        hm.put("Nokia", "Finlandia");
        hm.put("Sony", "Japon");
        
        // Punto 3 del taller 9
        
        System.out.println("¿Está Google en la tabla?: " + hm.containsKey("Google"));
        if(hm.containsKey("Google")) System.out.println("Google es de " + hm.get("Google"));
        
        System.out.println("¿Está Motorola en la tabla?: " + hm.containsKey("Motorola"));
        if(hm.containsKey("Motorola")) System.out.println("Motorola es de " + hm.get("Motorola"));
    }
    
}
