 

/**
 *
 * @author Yhoan Alejandro Guzmán
 */
public class Node {
    public int data;
    public Node next;
    public Node previous;
    public Node(int data)
    {
        next = null;
        previous = null;
        this.data = data;
    }
}