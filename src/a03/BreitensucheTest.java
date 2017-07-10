package a03;

public class BreitensucheTest {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		Graph graph = GraphLesen.FileToGraph("./GraphenBeispiele/graph8.txt", true);
		System.out.println(graph.toString());
		System.out.println(Breitensuche.depthBreadthSearch(graph, 3));
		System.out.println("Kuerzester Weg zwischen zwei Vertices: " + Breitensuche.shortestPathBetweenTwoVertices(graph, 3, 5));
		
		long end = System.currentTimeMillis();
		System.out.println("Ausfuehrung: " + (end - start) + " Millisekunden");
	}

}
