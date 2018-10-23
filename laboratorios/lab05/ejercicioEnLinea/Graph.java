package javaapplication1;

/**
 * This class is a solution for numeral 2.5 of the lab 5 Adapted from:
 * https://www.geeksforgeeks.org/graph-coloring-set-2-greedy-algorithm/
 *
 * @author Yhoan Alejandro Guzman
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
// This class represents an undirected graph using adjacency list 
class Graph {
    private int V;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency List 
    //Constructor 
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    //Function to add an edge into the graph 
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected 
    }
    // Assigns colors (starting from 0) to all vertices and 
    // prints the assignment of colors 
    boolean greedyColoring() {
        int result[] = new int[V];
        // Initialize all vertices as unassigned 
        Arrays.fill(result, -1);
        // Assign the first color to first vertex 
        result[0] = 0;
        // A temporary array to store the available colors. False 
        // value of available[cr] would mean that the color cr is 
        // assigned to one of its adjacent vertices 
        boolean available[] = new boolean[V];
        // Initially, all colors are available 
        Arrays.fill(available, true);
        // Assign colors to remaining V-1 vertices 
        for (int u = 1; u < V; u++) {
            // Process all adjacent vertices and flag their colors 
            // as unavailable 
            Iterator<Integer> it = adj[u].iterator();
            while (it.hasNext()) {
                int i = it.next();
                if (result[i] != -1) {
                    available[result[i]] = false;
                }
            }
            // Find the first available color 
            int cr;
            for (cr = 0; cr < V; cr++) {
                if (available[cr]) {
                    break;
                }
            }
            result[u] = cr; // Assign the found color 
            if (cr >= 2) {
                System.out.println("NOT BICOLORABLE");
                return false;
            }
            // Reset the values back to true for the next iteration 
            Arrays.fill(available, true);
        }
        // print the result 
        for (int u = 0; u < V; u++) {
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);
        }
        System.out.println("BICOLORABLE");
        return true;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(1, 4);
        System.out.println("Graph 1");
        g1.greedyColoring();
        System.out.println();
        Graph g2 = new Graph(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Graph 2");
        g2.greedyColoring();
    }
} 

