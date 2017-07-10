package a03;

/**
 * Testklasse zum Testen der Breitensuche.
 * 
 * @author @author Katharina-Sophia Bolinski s791580, Toni Kluth s780025
 */
public class BreitensucheTest {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Graph graph = GraphLesen.FileToGraph("./GraphenBeispiele/graph8.txt", true);
		System.out.println(graph.toString());
		System.out.println("Breitensuche: " + Breitensuche.depthBreadthSearch(graph, 3));
		System.out.println("Kuerzester Weg zwischen zwei Vertices: " + Breitensuche.shortestPathBetweenTwoVertices(graph, 3, 5));
		
		long end = System.currentTimeMillis();
		System.out.println("Ausfuehrung: " + (end - start) + " Millisekunden");
	}
}
