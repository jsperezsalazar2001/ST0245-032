package lab04;

/**
 * This class contains points 1.1 and 1.2 of the laboratory 4, 
 * a genealogical tree and a method to find the maternal grandmother are worked on.
 * @author Juan Sebastián Pérez Salazar
 */
public class BinaryTree {

    public Node root;

    /**
     * Constructor of the class
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Calculates the max between two values.
     * @param i value i
     * @param j value j
     * @return the max
     */
    private int max2(int i, int j) {
        if (i > j) {
            return i;
        }
        return j;
    }

    /**
     * Find the max height.
     * @param node root
     * @return the max height
     */
    private int maxheightAUX(Node node) {
        if (node == null) {
            return 0;
        } else {
            return max2(maxheightAUX(node.left), maxheightAUX(node.right)) + 1;
        }
    }

    /**
     * Auxiliar of the previous method.
     * @return the max height
     */
    public int maxheight() {
        return maxheightAUX(root);
    }
    
    /**
     * Print the tree in pre-order
     * @param node the root
     */
    private void recursivePrintAUX(Node node) {
        if (node != null) {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    /**
     * Auxiliar of the previous method.
     */
    public void recursivePrint() {
        recursivePrintAUX(root);
    }

    /**
     * Main method with test for the 1.1 point
     * @param args 
     */
    public static void main(String[] args){
        // implementation for the point 1.1
        BinaryTree bt = new BinaryTree();
        bt.root = new Node("Sebastian");
        bt.root.right = new Node("Carlos");
        bt.root.left = new Node("Beatriz");
        bt.root.left.left = new Node("Lucía");
        bt.root.left.left.left = new Node("Flora");
        bt.root.left.right = new Node("José");
        bt.root.right.left = new Node("Lilian");
        bt.root.right.right = new Node("Cesar");
        bt.root.right.right.left = new Node("Concha");
        
        bt.recursivePrint();
    }
}
