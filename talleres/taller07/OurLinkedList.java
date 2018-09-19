package taller7;

/**
 * This class contains the methods of a linked list.  
 * @author Juan Sebastián Pérez Salazar
 */
public class OurLinkedList {

    private Node first;
    private int size;
    
    public OurLinkedList()
    {
        size = 0;
        first = null;
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     * Returns the current size of the list
     * @return a integer
     */
    public int size()
    {
        return this.size;
    }
    
    /**
     * Returns the current first node of the list
     * @return a Node
     */
    public Node first(){
        return this.first; 
    }

    /**
     * Insert a data in the index position
     * @param data Value to insert
     * @param index Position to insert
     */
    public void insert(int data, int index)
    {
        Node newNode = new Node(data);
        if(size == 0){
            if(index == 0){
                this.first = newNode;
                size++;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }else if(size != 0){
            if(index == 0){
                newNode.next = this.first;
                this.first = newNode;
                size++;
            } else if( index > 0 && index < size){
                newNode.next = getNode(index-1).next;
                getNode(index-1).next = newNode;
                size++;
            } else if(index==size){
                getNode(index-1).next = newNode;
                size++;
            }else throw new IndexOutOfBoundsException();
        }else throw new IndexOutOfBoundsException();
                
    }

    /**
     * Delete the data in the index position
     * @param index Position to remove
     */
    public void remove(int index)
    {
        if(size != 0){
            if(index == 0){
                this.first = this.first.next;
                size--;
            } else if( index > 0 && index < size){
                getNode(index-1).next = getNode(index).next;
                size--;
            }else throw new IndexOutOfBoundsException();
        }else System.out.println("Lista Vacia");
    }
    
    /**
     * This method prints the values of the list.
     */
    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(getNode(i).data + " ");
        }
    }

    /**
     * This is the auxiliar method of containsRec
     * @param data value to look for
     * @return a boolean
     */
    public boolean containsRecAux(int data) {
        return containsRec(data, this.first);
    }
    
    /**
     * Check if there is a data in the list
     * @param data
     * @param temp
     * @return 
     */
    public boolean containsRec(int data, Node temp) {
        if (temp == null) return false; 
        if(temp.data == data) return true; 
        return containsRec(data, temp.next);
    }
    
    public static void main(String[] args){
        OurLinkedList list = new OurLinkedList();
        System.out.println(list.size());
        list.insert(23, 0);
        list.insert(12, 1);
        list.insert(10, 1);
        list.insert(30, 0);
        System.out.println(list.size());
        list.print();
        System.out.println();
        list.remove(0);
        System.out.println(list.size());
        list.print();
        System.out.println();
        System.out.println(list.containsRecAux(30));
        System.out.println(list.get(1));
    }

}
