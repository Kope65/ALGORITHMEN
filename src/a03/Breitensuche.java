package a03;

import java.util.*;


/**
 * @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 */

public class Breitensuche {

	private static HashMap<Vertex, Integer> search = new HashMap<Vertex, Integer>();
	private static Queue queue;
	private static Vertex[] pred;
	private static int[] dist;
	private static String[] col;
	private static int distCounter = 0;
	private static LinkedList<Vertex> shortestPath = new LinkedList<Vertex>();
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Graph graph = GraphLesen.FileToGraph("./GraphenBeispiele/graph8.txt", true);
		System.out.println(graph.toString());

		System.out.println("Breitensuche HashMap: " + depthBreadthSearch(graph, 3));
		System.out.println("Kuerzester Weg zwischen zwei Vertices: " + Breitensuche.shortestPathBetweenTwoVertices(graph, 3, 5));
		
		long end = System.currentTimeMillis();
		System.out.println("Ausfuehrung: " + (end - start) + " Millisekunden");
	}

	/**
	 * 
	 * @param graph
	 * @param startPoint
	 * @return
	 */
	public static HashMap<Vertex, Integer> depthBreadthSearch(Graph graph, int startPoint) {
		initializeGraph(graph, startPoint);
		System.out.println("Sei " + startPoint + " der Startvertex: ");
		for(int i = 0; i < graph.getNumberVertices(); i++) {
			search.put(pred[i], dist[i]);
			System.out.println("Vertex: " + i + " / Vorgaenger: " + pred[i] + " / Distanz: " + dist[i]);
		}
		return search;
	}
	
	/**
	 * 
	 * @param graph
	 * @param startPoint
	 * @param endPoint
	 * @return
	 */
	public static LinkedList<Vertex> shortestPathBetweenTwoVertices(Graph graph, int startPoint, int endPoint) {
		initializeGraph(graph, startPoint);
		if(col[endPoint].equals("white")) {
			return null;
		}
		shortestPath.add(new Vertex(endPoint));
		Vertex predVertex = pred[endPoint];
		while(predVertex.getId() != startPoint) {
			shortestPath.add(predVertex);
			predVertex = pred[predVertex.getId()];
		}
		shortestPath.add(predVertex);
		Collections.reverse(shortestPath);
		return shortestPath;		
	}
	
	/**
	 * 
	 * @param graph
	 * @param startPoint
	 */
	private static void initializeGraph(Graph graph, int startPoint) {
		Vertex startVertex = new Vertex(startPoint);
		queue = new LinkedList<Vertex>();
		pred = new Vertex[graph.getNumberVertices()];
		dist = new int[graph.getNumberVertices()];
		col = new String[graph.getNumberVertices()];	
		
		for (int i = 0; i < graph.getNumberVertices(); i++) {
			col[i] = "white";
			pred[i] = null;
			dist[i] = -1;
		}
		queue.add(startVertex.getId());		
		dist[startVertex.getId()] = 0;
		
		while (!queue.isEmpty()) {
			distCounter++;
			Vertex currentVertex = new Vertex((Integer) queue.element());
			col[currentVertex.getId()] = "grey";
			LinkedList<Vertex> neighbours = (LinkedList<Vertex>) graph.getNeighbours(currentVertex);
			for (int i = 0; i < neighbours.size(); i++) {
				int neighbour = neighbours.get(i).getId();
				if (col[neighbour].equals("white")) {
					queue.add(neighbour);
					col[neighbour] = "grey";
					pred[neighbour] = currentVertex;
					dist[neighbour] = distCounter;
				}
				col[currentVertex.getId()] = "black";
			}
			queue.remove();
		}
	}
}
//public class Breitensuche {
//	public static void main(String[] args) {
//		int[] starts = {};
//		int[] paths = {};
//		Graph[] graphs = { GraphLesen.FileToGraph(".src/a03/graph8.txt", true),
//				GraphLesen.FileToGraph("./src/a03/graph8.txt", true),
//				GraphLesen.FileToGraph("./src/a03/graph20.txt", true),
//				GraphLesen.FileToGraph("./src/a03//graph20.txt", false) };
//		for (int i = 0; i <= graphs.length; i++) {
//			System.out.print(graphs[i]);
//			long start = System.currentTimeMillis();
//			DepthBreadthSearch(graphs[i], starts[i]);
//			System.out.println(ShortestPath(graphs[i], starts[i], paths[i]));
//			long end = System.currentTimeMillis();
//			System.out.println("Took " + (end - start) + " Milliseconds");
//		}
//	}
//
//	/**
//	 * Funktion zur Breitensuche
//	 * 
//	 * @param graph
//	 * @param startPoint
//	 * @return
//	 * @throws IllegalArgumentException
//	 */
//
//	public static HashMap<Vertex, Integer> DepthBreadthSearch(Graph graph,
//			int startPoint) throws IllegalArgumentException {
//		if (graph.getVertex(startPoint) == null) {
//			throw new IllegalArgumentException("Startpoint doesn't exist.");
//		}
//		Queue<Vertex> q = new LinkedList<Vertex>();
//		List<Vertex> visited = new ArrayList();
//		HashMap<Vertex, Integer> depth = new HashMap<Vertex, Integer>();
//		Vertex og = graph.getVertex(startPoint);
//
//		depth.put(og, 0);
//		q.add(og);
//		visited.add(og);
//
//		System.out.printf("%-5s %-5s %-5s %-5d %-5s %-5d\n", "Vertex : ", og,
//				" pred: ", 0, "dist:", depth.get(og));
//		while (!q.isEmpty()) {
//			Vertex parent = q.remove();
//			Collection<Vertex> neighbours = graph.getNeighbours(parent);
//			while (!visited.containsAll(neighbours)) {
//				for (Vertex child : neighbours) {
//					if (!visited.contains(child)) {
//						depth.put(child, depth.get(parent) + 1);
//						visited.add(child);
//						q.add(child);
//						System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5d \n",
//								"Vertex : ", child.toString(), " pred: ",
//								parent, "dist:", depth.get(child));
//					}
//				}
//			}
//		}
//		return depth;
//	}
//
//	/**
//	 * 
//	 * @param graph
//	 *            ist der zu durchsuchende Graph
//	 * @param startPoint
//	 *            der Anfangsknoten
//	 * @param endPoint
//	 *            der Endknoten
//	 * @return
//	 * @throws IllegalArgumentException
//	 */
//	public static List<Vertex> ShortestPath(Graph graph, int startPoint,
//			int endPoint) throws IllegalArgumentException {
//		if (graph.getVertex(startPoint) == null
//				|| graph.getVertex(endPoint) == null) {
//			throw new IllegalArgumentException(
//					"Startpoint or Endpoint doesn't exist");
//		}
//		Queue<Vertex> q = new LinkedList<Vertex>();
//		List<Vertex> visited = new ArrayList();
//		HashMap<Vertex, Integer> depth = new HashMap<Vertex, Integer>();
//		HashMap<Vertex, Vertex> pred = new HashMap<Vertex, Vertex>();
//		Vertex og = graph.getVertex(startPoint);
//
//		depth.put(og, 0);
//		q.add(og);
//		visited.add(og);
//		boolean found = false;
//
//		while (!q.isEmpty()) {
//			Vertex parent = q.remove();
//			Collection<Vertex> neighbours = graph.getNeighbours(parent);
//			while (!visited.containsAll(neighbours)) {
//				for (Vertex child : neighbours) {
//					if (child.equals(graph.getVertex(endPoint))) {
//						pred.put(child, parent);
//						depth.put(child, depth.get(parent));
//						q.clear();
//						found = true;
//						break;
//					}
//					if (!visited.contains(child)) {
//						pred.put(child, parent);
//						depth.put(child, depth.get(parent));
//						visited.add(child);
//						q.add(child);
//					}
//				}
//				if (found) {
//					break;
//				}
//			}
//		}
//		List<Vertex> path = new ArrayList();
//		q.add(graph.getVertex(endPoint));
//		for (int i = 0; !q.isEmpty(); i++) {
//			Vertex parent = q.remove();
//			path.add(parent);
//			Vertex predes = pred.get(parent);
//			if (predes == graph.getVertex(startPoint)) {
//				path.add(predes);
//				return path;
//			}
//			q.add(predes);
//			if (i > graph.getNumberVertices()) {
//				break;
//			}
//		}
//		return null;
//	}
//}

