
/**
 * This class is a double linked list implementation.
 * This class is the solution for points 1.4 and 1.5 of the lab 3.
 * @author Yhoan Alejandro Guzman
 */
public class DoubleLinkedList {
    private Node first;
    private Node last;
    private int size;

    /**
     * Constructor of the class DoubleLinkedList
     */
    public DoubleLinkedList()
    {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    /**
     * This method returns the node at the specified position in the list.
     * @param index - index of the node to return
     * @return the node at the specified position in the list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp;
            if(index <= (this.size/2)){
                temp = this.first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            }else{
                temp = this.last;
                for (int i = this.size - 1; i > index; i--) {
                    temp = temp.previous;
                }
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * This method is used to return the data at the specified position in the list.
     * @param index - index of the data to return
     * @return the data at the specified position in the list
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
     * Returns the current last node of the list
     * @return a Node
     */
    public Node last(){
        return this.last; 
    }

    /**
     * This method inserts data at the index given position
     * @param data Value to insert
     * @param index Position to insert
     * @throws IndexOutOfBoundsException
     */
    public void insert(int data, int index) throws IndexOutOfBoundsException
    {
        Node newNode = new Node(data);
        if(size == 0){
            if(index == 0){
                this.first = newNode;
                this.last = this.first;
                size++;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }else if(size != 0){
            if(index == 0){
                newNode.next = this.first;
                this.first = newNode;
                newNode.next.previous = newNode;
                size++;
            } else if( index > 0 && index < size){            
                Node temp = getNode(index);
                temp.previous.next = newNode;
                temp.previous = newNode;
                newNode.next = temp;
                size++;
            } else if(index==size){
                Node temp = getNode(index-1);
                temp.next = newNode;
                newNode.previous = temp;
                this.last = newNode;
                size++;
            }else throw new IndexOutOfBoundsException();
        }else throw new IndexOutOfBoundsException();
    }

    /**
     * This method deletes the node that is the index given position
     * @param index Position to remove
     * @throws IndexOutOfBoundsException
     */
    public void remove(int index) throws IndexOutOfBoundsException
    {
        if(size != 0){
            if(index == 0){
                Node temp = this.first.next;
                this.first = temp;
                this.first.previous = null;
                size--;
            } else if(index == this.size -  1){
                Node temp = getNode(index);
                temp.previous.next = null;
                this.last = temp.previous;
                size--;
            }else if( index > 0 && index < this.size - 1){
                Node temp = getNode(index);
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
                size--;
            }else throw new IndexOutOfBoundsException();
        }else throw new IndexOutOfBoundsException();
    }

    /**
     * This method prints the values of the list.
     */
    public void print(){
        for(int i=0; i<size; i++){
            System.out.print(getNode(i).data + " ");
        }
        System.out.println();
    }

    /**
     * This is the auxiliar method of containsRec
     * @param data value to look for
     * @return boolean value
     */
    public boolean containsRecAux(int data) {
        return containsRecursive(data, this.first);
    }

    /**
     * Checks if the given data is in the list
     * @param data value to look for
     * @param temp node to compare
     * @return boolean value
     */
    public boolean containsRecursive(int data, Node temp) {
        if (temp == null) return false; 
        if(temp.data == data) return true; 
        return containsRecursive(data, temp.next);
    }

    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println("Removing when the list is empty:");
        System.out.println("For the case when it is tried to remove from an empty list, it is defined in the remove method to throw an \nindex out of bounds exception");
        System.out.println("Inserting when the list is empty:");
        System.out.println("List size: "+list.size());
        list.insert(0, 0);
        System.out.println("List size after inserting 0 at index 0: "+list.size());
        System.out.println("List: ");
        list.print();
        System.out.println("If it is tried to insert in an index different of 0 when the list is empty, the method will throw an \nindex out of bounds exception");
        System.out.println("Deleting the first element:");
        System.out.println("List before removing: ");
        list.insert(1, 1);
        list.print();
        list.remove(0);
        System.out.println("List after removing: ");
        list.print();
        System.out.println("Inserting at the first position");
        System.out.println("List before inserting");
        list.insert(0, 0);
        list.insert(2,2);
        list.print();
        list.insert(1000, 0);
        System.out.println("List after inserting");
        list.print();
        System.out.println("Inserting at the last position");
        System.out.println("List before inserting");
        list.print();
        list.insert(1000, list.size());
        System.out.println("List after inserting");
        list.print();
        System.out.println("Deleting the element at the last position");
        System.out.println("List before deleting");
        list.print();
        list.remove(list.size()-1);
        System.out.println("List after deleting");
        list.print();
    }
}