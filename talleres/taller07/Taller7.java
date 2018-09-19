package taller7;

/**
 * This class contains points 3 and 4 of the workshop
 * @author Juan Sebastián Pérez Salazar
 */
public class Taller7 {
    private int max;
    
    /**
     * This method is the auxiliar of the method maxValue. 
     * @param l 
     */
    public int maxValueAux(OurLinkedList l){
        if(l.size() != 0){
            this.max = l.first().data;
            return maxValue(l.first(), max);
        }else{ 
            System.out.print("Lista Vacia");
            return -1;
        }
    }
    
    /**
     * This method founds de maximun value at a list.
     * @param n
     * @param max
     * @return 
     */
    public int maxValue(Node n, int max){
        if(n == null){
            return this.max;
        }
        if (n.data>max){
            this.max = n.data;
            return maxValue(n.next, n.data);
        }else{
            return maxValue(n.next, max);
        }            
    }
    
    public static void main(String[] args){
        OurLinkedList list = new OurLinkedList();
        list.insert(23, 0);
        list.insert(42, 1);
        list.insert(10, 1);
        list.insert(30, 0);
        Taller7 t7 = new Taller7();
        System.out.println(t7.maxValueAux(list));
    }
    
}
