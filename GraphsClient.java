package Graphs;

public class GraphsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Gra g = new Gra();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        
        g.addEdge("A", "B", 8);
        g.addEdge("B", "D", 2);
        g.addEdge("C", "E", 3);
        g.addEdge("A", "D", 1);
        g.addEdge("A", "B", 5);
        System.out.println(g.containsEdge("E","E"));
        g.display();
        g.display();
        System.out.println(g.numVertex());
        g.removeVertex("B");
        System.out.println(g.containsEdge("A","D"));
        g.display();
        System.out.println(g.numVertex());
        System.out.println(g.numEdges());
	}

}
