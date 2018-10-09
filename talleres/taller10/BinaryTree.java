/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.  
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * @see <a href="https://docs.oracle.com/javase/9/docs/api/jdk/nashorn/api/tree/BinaryTree.html"> Árbol Binario</a>
 * @author Mauricio Toro, Andres Paez
 *
 */

public class BinaryTree {
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node(int d){
            data = d;
        }
    }
    // Sirve como raíz del árbol
    private Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        if(this.root == null){
            this.root = new Node(n);
        }else{
            insertarAux(root, n);
        }
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n) {
        if(n > node.data){
            if(node.right == null){
                node.right = new Node(n);
            }else{
                insertarAux(node.right, n);
            }
        }else if(n < node.data){
            if(node.left == null){
                node.left = new Node(n);
            }else{
                insertarAux(node.left, n);
            }
        }
    }

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) {
        if(node.data == n){
            return true;
        }
        if(node == null){
            return false;
        }
        if(n > node.data ){
            return buscarAux(node.right, n);
        }else{
            return buscarAux(node.left, n);
        }
    }

    /*
     * @param n el dato del nodo que se busca borrar.
     * Metodo auxiliar de buscarAux.
     * 
     */
    public void borrar(int n) {
        Node father = borrarAux(root, n);
        Node tLeft;
        Node tRight;
        if(father != null){
            if(father.right != null){
                if(father.right.data == n){
                    tLeft = father.rigth.left;
                    tRight = father.right.right;
                    father.right = tRight;
                    father.right.left = tLeft;
                }     
            }else if(father.left =! null)
                if(father.left.data == n){
                    tLeft = father.left.left;
                    tRight = father.left.right;
                    father.left = tRight;
                    father.left.left = tLeft;
                }
        }
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca borrar
     * nota: metodo recursivo.
     * borra un dato respetando claro las desigualdades en el árbol
     */ 
    private Node borrarAux(Node node, int n) {
        if(node == null){
            return null;
        }
        if(node.right != null){
            if(node.right.data == n)
                return node; 
        }else if(node.left =! null)
            if(node.left.data == n)
                return node; 
        if(n > node.data ){
            return borrarAux(node.right, n);
        }else{
            return borrarAux(node.left, n);
        }
    }
    /*
    Los metodos posteriores son para imprimir el arbol de manera
    que sirven para debuggeo
     */

    /**
     * @param node el nodo desde el cual se imprimirá
     * imprime el arbol desde el nodo node
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

}
