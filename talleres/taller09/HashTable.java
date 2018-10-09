 /**
 * This class is an implementation of the Hash Table concept
 * @author Yhoan Alejandro Guzmán
 * @version 1
 */
import java.util.*;
public class HashTable
{
    
    private ArrayList<LinkedList<Pair<String,Integer>>> table;
    
    /**
     * This mehtod defines the array with the given size.
     * @param size is the initial size wanted for the array.
     */
    public HashTable(int size){
        this.table = new ArrayList(size);
        for(int i = 0;i < size; i++){
        table.add(new LinkedList());
        }
    }

    /**
     * @param str is the key of the element that will serve as a reference when searching or inserting.
     * This method is used to give a position within the table, where % size ensures that only.
     * digits from 0 to size are used.
     */
    private int hashFunction(String str){
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            sum += ((int) str.charAt(i)) * i * (int) Math.pow(2,31-i);
        }
        return sum % table.size();
    }

    /**
     * @param k is the key of the element, that key will work as a reference when searching.
     * This method is used to get the element with key k, using the hashFunction method.
     */
    public int get(String k) throws Exception{
        int key =  hashFunction(k);
        for (Pair temp : this.table.get(key)) {
            if(temp.getKey() == k){
                return (int)temp.getValue();
            }
        }
        throw new Exception("Not found");
    }

    /**
     * @param kis the key of the element that will serve as a reference when searching.
     * @param v is the value associated with the key k.
     * This method is used to add a new value.
     */
    public void put(String k, int v){
        int index = hashFunction(k);
        Pair newElement = new Pair(k,v);
        this.table.get(index).add(newElement);
    }
    
}
