package laboratorio3;

import java.util.LinkedList;

/**
 * This class contains the methods corresponding to point 1.6 
 * of the laboratory implemented with LinkedList.
 * @author Juan Sebastián Pérez Salazar
 */
public class Bank {
    
    /**
     * This method simulates the service to the clients of a bank that are in different rows.
     * @param clients1 LinkedList of clients
     * @param clients2 LinkedList of clients
     * @param clients3 LinkedList of clients
     * @param clients4 LinkedList of clients
     */
    public static void asistingClients(LinkedList<String> clients1, LinkedList<String> clients2, LinkedList<String> clients3, LinkedList<String> clients4){
        int sum = clients1.size()+clients2.size()+clients3.size()+clients4.size();
        int cont=0;
        int cashier;
        while(cont<sum){
            
            if(cont%2==0) cashier=1;
            else cashier=2;
            if(clients1.size()>0){
                System.out.println(clients1.removeFirst()+" customer is being served by the cashier " + cashier);
                cont++;
            }
            
            if(cont%2==0) cashier=1;
            else cashier=2;
            if(clients2.size()>0){
                System.out.println(clients2.removeFirst()+" customer is being served by the cashier " + cashier);
                cont++;
            }
            
            if(cont%2==0) cashier=1;
            else cashier=2;
            if(clients3.size()>0){
                System.out.println(clients3.removeFirst()+" customer is being served by the cashier " + cashier);
                cont++;
            }
            
            if(cont%2==0) cashier=1;
            else cashier=2;
            if(clients4.size()>0){
                System.out.println(clients4.removeFirst()+" customer is being served by the cashier " + cashier);
                cont++;
            }
        }
    }
    
    /**
     * This method executes the tests of the previous methods with ArrayList and LinkedList.
     * @param args the command line arguments
     */
    public static void main(String[] args){
        LinkedList<String> clients1=new LinkedList<>(); LinkedList<String> clients2=new LinkedList<>(); 
        LinkedList<String> clients3=new LinkedList<>(); LinkedList<String> clients4=new LinkedList<>();
        
        // the linkedList is filled
        clients1.add("Greg");
        clients2.add("Craig");
        clients2.add("Allan");
        clients2.add("Marcus");
        clients3.add("Andrew");
        clients3.add("Eliza");
        clients4.add("Natts");
        
        // The method is called
        asistingClients(clients1, clients2, clients3, clients4);
    }
}