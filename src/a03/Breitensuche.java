package a03;


import java.util.*;

/**
 * Created by Katharina Bolinski 791580 & Toni Kluth
 */

public class Breitensuche{
	public static void main(String[] args){
		int[] starts = {};
		int[] paths	= {};
		Graph[] graphs = {GraphLesen.FileToGraph("/graph8.txt", true), GraphLesen.FileToGraph("/graph8.txt", true), GraphLesen.FileToGraph("/graph20.txt", true), GraphLesen.FileToGraph("/graph20.txt", false)};
		for (int i = 0; i < graphs.length; i++){
		System.out.print(graphs[i]);
		long start = System.currentTimeMillis();
        DepthBreadthSearch(graphs[i], starts[i]);
        System.out.println(ShortestPath(graphs[i], starts[i], paths[i]));
        long end = System.currentTimeMillis();
        System.out.println("Took " + (end - start) + " Milliseconds");
		}
	}
	
	/**
	 * Funktion zur Breitensuche
	 * @param graph
	 * @param startPoint
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	public static HashMap<Vertex, Integer> DepthBreadthSearch(Graph graph, int startPoint) throws IllegalArgumentException {
        if (graph.getVertex(startPoint) == null) {
            throw new IllegalArgumentException("Startpoint doesn't exist.");
        }
        Queue<Vertex> q = new LinkedList<Vertex>();
        List<Vertex> visited = new ArrayList();
        HashMap<Vertex, Integer> depth = new HashMap<Vertex, Integer>();
        Vertex og = graph.getVertex(startPoint);

        depth.put(og, 0);
        q.add(og);
        visited.add(og);

        System.out.printf("%-5s %-5s %-5s %-5d %-5s %-5d\n", "Vertex : ", og, " pred: ", 0, "dist:", depth.get(og));
        while (!q.isEmpty()) {
            Vertex parent = q.remove();
            Collection<Vertex> neighbours = graph.getNeighbours(parent);
            while (!visited.containsAll(neighbours)) {
                for (Vertex child : neighbours) {
                    if (!visited.contains(child)) {
                        depth.put(child, depth.get(parent) + 1);
                        visited.add(child);
                        q.add(child);
                        System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5d \n", "Vertex : ", child.toString(), " pred: ", parent, "dist:", depth.get(child));
                    }
                }
            }
        }
        return depth;
    }

	
	/**
	 * 
	 * @param graph ist der zu durchsuchende Graph
	 * @param startPoint der Anfangsknoten
	 * @param endPoint der Endknoten
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static List<Vertex> ShortestPath(Graph graph, int startPoint, int endPoint) throws IllegalArgumentException {
        if (graph.getVertex(startPoint) == null || graph.getVertex(endPoint) == null) {
            throw new IllegalArgumentException("Startpoint or Endpoint doesn't exist");
        }
        Queue<Vertex> q = new LinkedList<Vertex>();
        List<Vertex> visited = new ArrayList();
        HashMap<Vertex, Integer> depth = new HashMap<Vertex, Integer>();
        HashMap<Vertex, Vertex> pred = new HashMap<Vertex, Vertex>();
        Vertex og = graph.getVertex(startPoint);

        depth.put(og, 0);
        q.add(og);
        visited.add(og);
        boolean found = false;

        while (!q.isEmpty()) {
            Vertex parent = q.remove();
            Collection<Vertex> neighbours = graph.getNeighbours(parent);
            while (!visited.containsAll(neighbours)) {
                for (Vertex child : neighbours) {
                    if (child.equals(graph.getVertex(endPoint))) {
                        pred.put(child, parent);
                        depth.put(child, depth.get(parent) + 1);
                        q.clear();
                        found = true;
                        break;
                    }
                    if (!visited.contains(child)) {
                        pred.put(child, parent);
                        depth.put(child, depth.get(parent) + 1);
                        visited.add(child);
                        q.add(child);
                    }
                }
                if (found) {
                    break;
                }
            }
        }
        List<Vertex> path = new ArrayList();
        q.add(graph.getVertex(endPoint));
        for (int i = 0; !q.isEmpty(); i++) {
            Vertex parent = q.remove();
            path.add(parent);
            Vertex predes = pred.get(parent);
            if (predes == graph.getVertex(startPoint)) {
                path.add(predes);
                return path;
            }
            q.add(predes);
            if (i > graph.getNumberVertices()) {
                break;
            }
        }
        return null;
    }
}
 

//Algorithm Breadth-First-Search (G,s)
//   // traverses G in BFS-strategy
//   // let s be start vertex, Q be a queue
//  Initialize-BFS(s);
//   while (Q != empty)
//    u = Dequeue(Q);
//    for (v є Adj(u)) // for all neighbours of u
//       if (col[v] == white) // v is not visited
//          col[v] = grey;
//          dist[v] = dist[u] + 1;
//          pred[v] = u;
//          Enqueue(Q, v);
//    col[u] = black;

//Initialize-BFS(G,s)
//// s - start vertex for BFS;
//// Q - empty queue;
//col[s] = grey;
//dist[s] = 0;
//pred[s] = null;
//Enqueue(Q, s);
//for (v є V \ {s})
//   col[v] = white;
//   dist[v] = MAXINT;
//   pred[v] = null;