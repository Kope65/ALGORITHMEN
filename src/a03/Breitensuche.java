package a03;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Klasse 'Breitensuche' zum finden der kuerzesten Wege in einem 'Graph'.
 * 
 * @author @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 */
public class Breitensuche {

	private static Integer[][] search; 											// Eine Collection aller Vertices mit ihren Vorgaengern und ihrer Distanz
	private static LinkedList<Vertex> shortestPath = new LinkedList<Vertex>();	// Eine LinkedList die den kuerzesten Weg zwischen zwei Vertices enthaelt
	private static Queue queue;													// Eine Queue mit den vom Startvertex erreichten Vertices
	private static Integer[] pred;												// Array mit dem Vorgaenger des jeweiligen Vertex 'Index'
	private static int[] dist;													// Array mit der Distanz des jeweiligen Vertex 'Index'
	private static String[] col;												// Array mit der Farbe des jeweiligen Vertex 'Index'
	private static int distCounter;												// Der Zaehler für die Distanz
	
	// Main-Methode zum Testen der Klasse 'Breitensuche'
	public static void main(String[] args) {
		long start = System.currentTimeMillis();		
		Graph graph = GraphLesen.FileToGraph("./GraphenBeispiele/graph8.txt", true);
		System.out.println(graph.toString());
		System.out.println("Breitensuche: " + Breitensuche.depthBreadthSearch(graph, 3));
		for (int i = 0; i < search.length; i++) {		     
		    	 System.out.print("Vertex: " + i + "\n" + "Vorgaenger: " + search[i][0] + " Distanz: " + search[i][1] + "\n");		     
		 }
		System.out.println("Kuerzester Weg zwischen zwei Vertices: " + Breitensuche.shortestPathBetweenTwoVertices(graph, 3, 5));		
		long end = System.currentTimeMillis();
		System.out.println("Ausfuehrung: " + (end - start) + " Millisekunden");
	}
	
	/**
	 * Statische Methode zum Durchlaufen eines 'Graph' mit der Breitensuche. 
	 * 
	 * @param graph Der 'Graph' fuer den die Breitensuche durchgefuehrt werden soll. 
	 * @param startPoint Der 'Vertex' bei dem die Breitensuche im uebergebenen 'Graph' startet.
	 * @return Liefert ein int[][] mit den kuerzesten Wegen eines Startvertex zu allen anderen erreichbaren Vertices zurueck. 
	 */
	public static Integer[][] depthBreadthSearch(Graph graph, int startPoint) {
		initializeGraph(graph, startPoint); 					// Initialisiert alle Parameter mit dem uebergebenen 'Graph' und dem 'startPoint'
		search = new Integer[graph.getNumberVertices()][2];		// Initialisiere Groesse des zurueckzuliefernden 'Integer[][]'
		for(int i = 0; i < graph.getNumberVertices(); i++) {	// Fuer alle Indices in 'search'
			search[i][0] = pred[i];					// Fuege Vorgaenger des Vertex 'i' in 'search' ein
			search[i][1] = dist[i];					// Fuege Distanz des Vertex 'i' in 'search' ein
		}
		return search; 	// Liefere 'Integer[][]' zurueck
	}

	/**
	 * Statische Methode zum finden des kuerzesten Weges zwischen zwei Vertices in einem uebergebenen 'Graph'. 
	 * 
	 * @param graph Der 'Graph' fuer den die Breitensuche durchgefuehrt werden soll. 
	 * @param startPoint Der 'Vertex' bei dem die Breitensuche im uebergebenen 'Graph' startet.
	 * @param endPoint Der 'Vertex' zu dem der kuerzeste Weg im uebergebenen 'Graph' gefunden werden soll.
	 * @return Liefert eine LinkedList<Vertex> mit dem kuerzesten Weg vom 'startPoint' zum 'endPoint' zurueck.
	 * 		   Liefert 'null' zurueck, wenn der 'endPoint' nicht erreichbar ist.
	 */
	public static LinkedList<Vertex> shortestPathBetweenTwoVertices(Graph graph, int startPoint, int endPoint) {
		initializeGraph(graph, startPoint); // Initialisiert alle Parameter mit dem uebergebenen 'Graph' und dem 'startPoint'
		if(col[endPoint].equals("white")) { // Wenn der 'endPoint' die Farbe "white" ('Vertex' unbesucht) hat:
			return null;					// Liefere 'null' zurueck. 'endPoint' nicht erreichbar
		}
		shortestPath.add(new Vertex(endPoint));  	// Fuegt 'endPoint' in die zurueckzuliefernde 'LinkedList' ein
		int predVertex = pred[endPoint]; 			// Helfervariable: enthaelt den Vorgaenger des 'endPoint'
		while(predVertex != startPoint) { 	// Solange der 'endPoint' ungleich 'startPoint' ist:
			shortestPath.add(new Vertex(predVertex)); 			// Fuege aktuellen Vorgaenger in 'LinkedList' ein 
			predVertex = pred[predVertex];	// Uebergebe Helfervariable den Vorgaenger des Vorgaengers
		}
		shortestPath.add(new Vertex(predVertex));		// Fuege den letzten Vorgaenger in 'LinkedList' ein (enspricht 'startPoint')
		Collections.reverse(shortestPath);	// Invertiere die Reihenfolge der zurueckzuliefernden 'LinkedList'
		return shortestPath;				// Liefere 'LinkedList' zurueck
	}
	
	/**
	 * Private, statische Methode der Klasse 'Breitensuche'. In dieser Methode werden alle noetigen Parameter fuer 
	 * die Breitensuche initialisiert.
	 * 
	 * @param graph Der 'Graph' fuer den die Breitensuche durchgefuehrt werden soll. 
	 * @param startPoint Der 'Vertex' bei dem die Breitensuche im uebergebenen 'Graph' startet.
	 */
	private static void initializeGraph(Graph graph, int startPoint) {
		Vertex startVertex = new Vertex(startPoint);
		queue = new LinkedList<Vertex>();
		pred = new Integer[graph.getNumberVertices()]; 	// Initialisiere Groesse des Arrays 'pred'
		dist = new int[graph.getNumberVertices()];		// Initialisiere Groesse des Arrays 'dist'
		col = new String[graph.getNumberVertices()];	// Initialisiere Groesse des Arrays 'col'
		distCounter = 0;
		
		for (int i = 0; i < graph.getNumberVertices(); i++) { // Fuer alle Elemente der Arrays, initialisiere Defaultwerte
			col[i] = "white";
			pred[i] = null;
			dist[i] = -1;
		}
		queue.add(startVertex.getId());							// Fuegt den Startvertex als erstes Element in die Queue ein
		dist[startVertex.getId()] = distCounter;				// Defaultdistanz des Startvertex = 0
		
		while (!queue.isEmpty()) {								// Solange 'queue' nicht leer ist:
			distCounter++; 										// Zaehle Zaehler hoch			
			Integer currentVertex = (Integer) queue.element(); 	// Helfervariable: enthaelt den aktuellen 'Vertex' der 'Queue'
			col[currentVertex] = "grey"; 			// Setze Farbe des aktuellen 'Vertex' auf "grey" ('Vertex' besucht, Nachbarn unbesucht)
			LinkedList<Vertex> neighbours = (LinkedList<Vertex>) graph.getNeighbours(currentVertex); // Liste mit allen Nachbarn des aktuellen 'Vertex'
			
			for (int i = 0; i < neighbours.size(); i++) { 	// Fuer alle Nachbarn:
				int neighbour = neighbours.get(i).getId(); 		// Helfervariable: enthaelt den aktuellen Nachbarn des aktuellen 'Vertex'
				if (col[neighbour].equals("white")) { 			// Wenn die Farbe des aktuellen Nachbarn "white" ('Vertex' unbesucht) ist:
					queue.add(neighbour);				 		// Fuege aktuellen Nachbarn in der 'Queue' ein
					col[neighbour] = "grey";					// Setze Farbe des aktuellen Nachbarn auf "grey"
					pred[neighbour] = currentVertex;			// Lege den aktuellen 'Vertex' als Vorgaenger des aktuellen Nachbarn fest
					dist[neighbour] = distCounter;				// Lege die Distanz zum Startvertex fest
				}
				col[currentVertex] = "black";		// Setze Farbe des aktuellen 'Vertex' auf "black" ('Vertex' und alle Nachbarn besucht)
			}
			queue.remove();									// Entferne aktuellen 'Vertex' aus der 'Queue'
		}
	}
}