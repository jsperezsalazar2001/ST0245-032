package lab05;

import java.util.ArrayList;

/**
 * This class is an implementation of a digraph using adjacency matrix.
 * @author Juan Sebastián Pérez Salazar
 * @version 1
 */
public class DigraphAM extends Graph {

    int[][] matriz;
    
    /**
     * This is the constructor of the class
     * @param size number of vertices
     */
    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
    }

    /**
     * This method return the weight between two vertex
     * @param source first vertex
     * @param destination second vertex
     * @return weight of the relation
     */
    @Override
    public int getWeight(int source, int destination) {
        return matriz[source][destination];
    }

    /**
     * This method add an arc between two vertex
     * @param source first vertex
     * @param destination second vertex
     * @param weight weight to add
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    /**
     * This method return an ArrayList with the vertex successors. 
     * @param vertex vertex to get the successors
     * @return an ArrayList
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors = new ArrayList();
        for(int i=0; i< super.size; i++)
            if(matriz[vertex][i] != 0)
                successors.add(i);
        return successors;
    }
}
