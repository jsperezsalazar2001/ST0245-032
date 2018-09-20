package taller7;

/**
 * This class contains points 3 and 4 of the workshop
 * @author Juan Sebastián Pérez Salazar
 * @author Yhoan Alejandro Guzman
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
        //complexity: O(n), where n is the length of the list
    }

    /**
     * This method returns whether the two linked list are equal or not.
     * @param a is the first node of one of the linked list
     * @param b is the first node of the other linked list
     * @return true if the list are equal, false if not
     */
    public boolean sameList(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }else{
            //This method is implemented in a way that it can work in both java's 
            //LinkedList class and our LinkedList class
            if(a == null && b != null){
                return false;
            }else if(b == null){
                return false;
            }
            if (a.data != b.data){
                return false;
            }
            return sameList(a.next, b.next);//c4
            //complexity: O(n), where n is the length of any of the list
        }
    }

    public static void main(String[] args){
        Taller7 t7 = new Taller7();
        OurLinkedList list = new OurLinkedList();
        list.insert(23, 0);
        list.insert(42, 1);
        list.insert(10, 1);
        list.insert(30, 0);
        System.out.println(t7.maxValueAux(list));
        OurLinkedList listA = new OurLinkedList();
        OurLinkedList listB = new OurLinkedList();
        for(int i = 0; i <= 5; i++){
            listA.insert(i);
            listB.insert(i);
        }
        System.out.println(t7.sameList(listA.first(),listB.first()));
        listA.insert(2);
        System.out.println(t7.sameList(listA.first(),listB.first()));
    }
}
