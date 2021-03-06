package lab04;

/**
 * This class contains points 1.1 and 1.2 of the laboratory 4, a genealogical
 * tree and a method to find the maternal grandmother are worked on.
 *
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
     * Print the tree in pre-order
     *
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

    public Node findingNode(Node node, String name) {
        if(node == null)
            return null;
        else{
            if(node.data.equals(name)) {
                return node;
            }
            Node left = findingNode(node.left, name);
            if(left != null)
                return left;
            Node right = findingNode(node.right, name);
            if(right != null)
                return right;
            return null;
        }    
    }

    public String getGrandMothersName(String name) {
        Node person = findingNode(root, name);
        System.out.println(person.data);
        if (person != null) {
            person = person.left;
            if (person != null) {
                person = person.left;
                if (person != null) {
                    return person.data;
                }
            }
        }
        return "";
    }

    /**
     * Main method with test for the 1.1 point
     *
     * @param args
     */
    public static void main(String[] args) {
        // implementation for the point 1.1
        BinaryTree bt = new BinaryTree();
        bt.root = new Node("Sebastian");
        bt.root.right = new Node("Carlos");
        bt.root.left = new Node("Beatriz");
        bt.root.left.left = new Node("Lucía");
        bt.root.left.left.left = new Node("Flora");
        bt.root.left.right = new Node("Jose");
        bt.root.right.left = new Node("Lilian");
        bt.root.right.left.left = new Node("Nirma");
        bt.root.right.right = new Node("Cesar");
        bt.root.right.right.left = new Node("Concha");

        bt.recursivePrint();

        System.out.println(bt.getGrandMothersName("Carlos"));
    }
}
