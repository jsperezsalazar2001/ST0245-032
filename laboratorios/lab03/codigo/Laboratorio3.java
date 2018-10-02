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

    /**
     * This method adds a data to an ArrayList if the data is not in the list.
     * @param list This is the ArrayList with Integers
     * @param data This is the value to add
     */
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
    
    /**
     * This method adds a data to a LinkedList if the data is not in the list.
     * @param list This is the LinkedList with Integers
     * @param data This is the value to add
     */
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
    
    /**
     * This method assigns the fridges that are in the warehouse to the received requests.
     * @param fridges The ArrayList with fridges
     * @param requests The ArrayList with requests
     */
    public static void assignFridgesArrayList(ArrayList<Fridge> fridges, ArrayList<Request> requests){
        for(int i=0; i<requests.size(); i++){
            Request s = requests.get(i);
            System.out.println("The store " + s.getStoreName() + " has assigned the following refrigerators: ");
            for(int j=0; j<s.getCantN(); j++){
                if(fridges.size()>0){
                    System.out.println(fridges.get(0).toString());
                    fridges.remove(0);
                }else{
                    System.out.println("Not assigned");
                }
                System.out.println();
            }
        }
    }
    
    /**
     * This method assigns the fridges that are in the warehouse to the received requests.
     * @param fridges The LinkedList with fridges
     * @param requests The LinkedList with requests
     */
    public static void assignFridgesLinkedList(LinkedList<Fridge> fridges, LinkedList<Request> requests){
        for(int i=0; i<requests.size(); i++){
            Request s = requests.get(i);
            System.out.println("The store " + s.getStoreName() + " has assigned the following refrigerators: ");
            for(int j=0; j<s.getCantN(); j++){
                if(fridges.size()>0){
                    System.out.println(fridges.removeFirst().toString());
                }else{
                    System.out.println("Not assigned");
                }
                System.out.println();
            }
        }
    }
    
    /**
     * This method calculates which is the most appropriate place to place a pivot with ArrayList.
     * @param list This is the ArrayList with Integers
     */
    public static void betterPivotArrayList(ArrayList<Integer> list){
        int cont =0;
        int cont2 =0;
        int indexB =0;
        
        for(int i=0; i<list.size(); i++){
            
        }
    }
    
    /**
     * This method calculates which is the most appropriate place to place a pivot with LinkedList.
     * @param list This is the LinkedList with Integers
     */
    public static void betterPivotLinkedList(LinkedList<Integer> list){}
    
    /**
     * This method executes the tests of the previous methods with ArrayList and LinkedList.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Tests for the smartInsertArrayList method
        
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
        System.out.println(listB.size());
        
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
        
        requestsB.add(s); requestsB.add(so); requestsB.add(sol);
        
        fridgesB.addFirst(n); fridgesB.addFirst(ne); fridgesB.addFirst(nev); fridgesB.addFirst(neve);
        fridgesB.addFirst(never); fridgesB.addFirst(nevera); fridgesB.addFirst(nevern);
        
        assignFridgesLinkedList(fridgesB, requestsB);
       
       
    }
    
}