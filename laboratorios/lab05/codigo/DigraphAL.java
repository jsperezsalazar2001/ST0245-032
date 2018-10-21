package lab05;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class is an implementation of a digraph using adjacency lists.
 * @author Juan Sebastián Pérez Salazar
 * @version 1
 */
public class DigraphAL extends Graph {

    ArrayList<LinkedList<Pair>> listaAdyacencia = new ArrayList();
    
    /**
     * This is the constructor of the class
     * @param size number of vertices
     */
    public DigraphAL(int size) {
        super(size);
        for(int i = 0; i< size; i++)
            listaAdyacencia.add(new LinkedList());
    }

    /**
     * This method return the weight between two vertex
     * @param source first vertex
     * @param destination second vertex
     * @return weight of the relation
     */
    @Override
    public int getWeight(int source, int destination) {
        LinkedList<Pair> parejas = listaAdyacencia.get(source);
        for(Pair p: parejas)
            if(p.vertex == destination)
                return p.weight;
        
        return 0; 
    }
    
    /**
     * This method add an arc between two vertex
     * @param source first vertex
     * @param destination second vertex
     * @param weight weight to add
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        listaAdyacencia.get(source).add(new Pair(destination, weight));
    }

    /**
     * This method return an ArrayList with the vertex successors. 
     * @param vertex vertex to get the successors
     * @return an ArrayList
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> successors = new ArrayList();
        for(Pair p: listaAdyacencia.get(vertex))
            successors.add(p.vertex);
        
        return successors;
    }
}
