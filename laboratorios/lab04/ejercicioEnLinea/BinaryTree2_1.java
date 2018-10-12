package lab04;

import java.util.Scanner;

/**
 *
 * @author Juan Sebastián Pérez Salazar
 */
public class BinaryTree2_1 {

    public Node root;

    /**
     * This method adds a value to the tree, method taken from:
     * https://www.baeldung.com/java-binary-tree
     *
     * @param current actual Node
     * @param data Data to adding
     * @return
     */
    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    /**
     * Auxiliar of previous method. 
     * @param data Data to add 
     */
    public void add(int data) {
        root = addRecursive(root, data);
    }
    
    /**
     * This method is responsible for printing the tree in pre-order.
     * @param node The root
     */
    public void printPreOrder(Node node){
        if(node != null){
            System.out.println(node.data);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
    
    /**
     * This method is responsible for printing the tree in pos-order.
     * @param node The root
     */
    public void printPosOrder(Node node){
        if(node != null){
            printPosOrder(node.left);
            printPosOrder(node.right);
            System.out.println(node.data);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree2_1 bt = new BinaryTree2_1();
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        while(data != -1){
            bt.add(data);
            data = sc.nextInt();
        }
        System.out.println();
        bt.printPosOrder(bt.root);
    }

}
