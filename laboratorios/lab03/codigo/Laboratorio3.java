package laboratorio3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class contains the methods corresponding to point 1 
 * of the laboratory implemented with ArrayList and LinkedList.
 * @author Juan Sebastián Pérez Salazar
 */
public class Laboratorio3 {
    
    public static ArrayList<Fridge> fridgesA = new ArrayList<>();
    public static LinkedList<Fridge> fridgesB = new LinkedList<>();
    public static ArrayList<Request> requestsA = new ArrayList<>();
    public static LinkedList<Request> requestsB = new LinkedList<>();

    public static void smartInsertArrayList(ArrayList<Integer> list, int data){
        boolean already = false;
        for(int i =0; i<list.size(); i++){
            if(list.get(i)==data){
                already = true;
                break;
            }
        }
        if(already==false) list.add(data);
    }
    
    public static void smartInsertLinkedList(LinkedList<Integer> list, int data){
        boolean already = false;
        for(int i =0; i<list.size(); i++){
            if(list.get(i)==data){
                already = true;
                break;
            }
        }
        if(already==false) list.add(data);
    }
    
    public static void assignFridgesArrayList(ArrayList<Fridge> neveras, ArrayList<Request> solicitudes){
        for(int i=0; i<solicitudes.size(); i++){
            Request s = solicitudes.get(i);
            System.out.println("The store " + s.getNombTienda() + " has assigned the following refrigerators: ");
            for(int j=0; j<s.getCantN(); j++){
                if(neveras.size()>0){
                    System.out.println(neveras.get(0).toString());
                    neveras.remove(0);
                }else{
                    System.out.println("Not assigned");
                }
                System.out.println();
            }
        }
    }
    
    public static void assignFridgesLinkedList(LinkedList<Fridge> neveras, LinkedList<Request> solicitudes){
        for(int i=0; i<solicitudes.size(); i++){
            Request s = solicitudes.get(i);
            System.out.println("The store " + s.getNombTienda() + " has assigned the following refrigerators: ");
            for(int j=0; j<s.getCantN(); j++){
                if(neveras.size()>0){
                    System.out.println(neveras.removeFirst().toString());
                }else{
                    System.out.println("Not assigned");
                }
                System.out.println();
            }
        }
    }
    
    
    /**
     * 
     * This method executes the tests of the previous methods with ArrayList and LinkedList.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*//Tests for the smartInsertArrayList method
        
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(0); listA.add(1); listA.add(2); listA.add(3); listA.add(4); listA.add(5); listA.add(6);
        smartInsertArrayList(listA, 6);
        System.out.println(listA.size());
        smartInsertArrayList(listA, 7);
        System.out.println(listA.size());
        //Tests for the smartInsertLinkedList method
        
        LinkedList<Integer> listB = new LinkedList<>();
        listB.add(0); listB.add(1); listB.add(2); listB.add(3); listB.add(4); listB.add(5); listB.add(6);
        smartInsertLinkedList(listB, 6);
        System.out.println(listB.size());
        smartInsertLinkedList(listB, 7);
        System.out.println(listB.size());*/
        
        //Creation of objects
        
        Request s = new Request("Good Fridges", 2); Request so = new Request("Fridgereitor", 2);
        Request sol = new Request("Snow Contain", 4);
        
        Fridge n = new Fridge(2345, "It's red"); Fridge ne = new Fridge(6546, "It's big"); Fridge nev = new Fridge(8745, "It's green");
        Fridge neve = new Fridge(2364, "It's gray"); Fridge never = new Fridge(9833, "It's small"); Fridge nevera = new Fridge(8643, "It's double");
        Fridge nevern = new Fridge(1234, "Without freezer");
        
        //Tests for the assignFridgesArrayList method
        
        requestsA.add(s); requestsA.add(so); requestsA.add(sol);
        
        fridgesA.add(n); fridgesA.add(0, ne); fridgesA.add(0, nev); fridgesA.add(0, neve);
        fridgesA.add(0, never); fridgesA.add(0, nevera); fridgesA.add(0, nevern);
        
        assignFridgesArrayList(fridgesA, requestsA);
        
        //Tests for the assignFridgesLinkedList method
        
        /*requestsB.add(s); requestsB.add(so); requestsB.add(sol);
        
        fridgesB.addFirst(n); fridgesB.addFirst(ne); fridgesB.addFirst(nev); fridgesB.addFirst(neve);
        fridgesB.addFirst(never); fridgesB.addFirst(nevera); fridgesB.addFirst(nevern);
        
        assignFridgesLinkedList(fridgesB, requestsB);*/
    }
    
}
