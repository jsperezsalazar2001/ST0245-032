package taller8;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Juan Sebastian Perez Salazar
 */
public class Main {

    public static Stack<Nevera> neveras = new Stack<>();
    public static ArrayList<Solicitud> solicitudes = new ArrayList<>();
    
    public static void asignarNevera(){
        for(int i=0; i<solicitudes.size(); i++){
            Solicitud s = solicitudes.get(i);
            System.out.println("La tienda " + s.getNombTienda() + " tiene asignadas las siguientes neveras: ");
            for(int j=0; j<s.getCantN(); j++){
                if(neveras.size()>0){
                    System.out.println(neveras.pop().toString());
                }else{
                    System.out.println("No asignada");
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Método main que se encarga de realizar las pruebas del método anterior. 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solicitud s = new Solicitud("Neveras buenas", 2);
        Solicitud so = new Solicitud("Neveras calidad", 2);
        Solicitud sol = new Solicitud("La neve", 4);
        
        Nevera n = new Nevera(2345, "Es roja");
        Nevera ne = new Nevera(6546, "Es grande");
        Nevera nev = new Nevera(8745, "Es verde");
        Nevera neve = new Nevera(2364, "Es plateada");
        Nevera never = new Nevera(9833, "Es pequeña");
        Nevera nevera = new Nevera(8643, "Es doble");
        Nevera nevern = new Nevera(1234, "Sin congelador");
        
        solicitudes.add(s);
        solicitudes.add(so);
        solicitudes.add(sol);
        
        neveras.push(n);
        neveras.push(ne);
        neveras.push(nev);
        neveras.push(neve);
        neveras.push(never);
        neveras.push(nevera);
        neveras.push(nevern);
        
        asignarNevera();
        
    }
    
}
