package lab05;

import java.util.ArrayList;
/**
 * Abstract class for implementations of Digraphs.
 * @author Mauricio Toro
 * @version 1
 */
public abstract class Graph
{
   protected int size;
   
   /**
    * Constructor of the abstract class
    * @param vertex number of vertex
    */
   public  Graph(int vertex) 
   {
       size = vertex;
   }
   
   public  abstract void addArc(int source, int destination, int weight);
   public abstract ArrayList<Integer> getSuccessors(int vertice);
   public abstract int getWeight(int source, int destination);
   
   /**
    * This method return the size. 
    * @return the size
    */
   public int size() {return size;}
}