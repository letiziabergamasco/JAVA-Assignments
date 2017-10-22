package graphs;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		DirectedGraph graph = new DirectedGraph();
		
		Node node1 = new Node(1,"white");
		Node node2 = new Node(2,"red");
		Node node3 = new Node(3,"green");
		Node node4 = new Node(4,"blue");
		Node node5 = new Node(5,"yellow");
		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		ArrayList<Node> neigh_list = new ArrayList<Node>();
		neigh_list.add(node2);
		neigh_list.add(node3);
		neigh_list.add(node4);
		graph.addNeighbourList(node1, neigh_list);
		graph.addNeighbour(node2, node3);
	
		System.out.println("DIRECTED GRAPH");
		graph.printNodes();
		System.out.println("");
		ArrayList<Node> neighbours = graph.getNeighboursOfNode(node1);
		System.out.print("Neighbors of node " + node1.getId() + " are: ");
		for(int i=0; i<neighbours.size(); i++) {
			System.out.print(neighbours.get(i).getId() + " ");
		}
		System.out.println("");
		System.out.println("");
		
		graph.deleteNeighbour(node1, node2);
		graph.printNodes();
		System.out.println("");
		
		graph.deleteNeighbour(node4, node5);
		
		UndirectedGraph undirected_graph = new UndirectedGraph();

		undirected_graph.addNode(node1);
		undirected_graph.addNode(node3);
		undirected_graph.addNode(node5);
		undirected_graph.addNeighbour(node1, node3);
		undirected_graph.addNeighbour(node1, node5);
		undirected_graph.addNeighbour(node5, node3);
	
		System.out.println("");
		System.out.println("UNDIRECTED GRAPH");
		undirected_graph.printNodes();
		System.out.println("");
		
		undirected_graph.deleteNeighbour(node3, node1);
		undirected_graph.printNodes();
		System.out.println("");
		
		LabelledDirectedGraph labelled_graph = new LabelledDirectedGraph();
		
		labelled_graph.addNode(node1);
		labelled_graph.addNode(node2);
		labelled_graph.addNode(node3);
		Edge edge1 = new Edge(node2, "bright");
		Edge edge2 = new Edge(node3, "dark");
		labelled_graph.addEdge(node1, edge1);
		labelled_graph.addEdge(node1, edge2);
		
		System.out.println("LABELLED DIRECTED GRAPH");
		labelled_graph.printNodes();
		System.out.println("");
		
		labelled_graph.deleteEdge(node1, edge2);
		labelled_graph.printNodes();

	}

}
