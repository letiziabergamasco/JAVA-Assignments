package graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class UndirectedGraph {
	
	private HashMap< Node, ArrayList<Node> > graph = new HashMap< Node, ArrayList<Node> >();
	
	public UndirectedGraph() {}
	
	public void addNode(Node n) {
		if(!graph.containsKey(n)) {
			graph.put(n, new ArrayList<Node>());
		}
		else {
			System.out.println("Node " + n.getId() + " is already in graph");
		}
	}
	
	public void addNeighbour(Node p, Node n) {
		
		if(graph.containsKey(p)) {
			if(!graph.containsKey(n)) {
				System.out.println("Node " + n.getId() + " is not in graph");
				return;
			}
			ArrayList<Node> neigh_list_p = graph.get(p);
			neigh_list_p.add(n);
			ArrayList<Node> neigh_list_n = graph.get(n);
			neigh_list_n.add(p);
			
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public void addNeighbourList(Node p, ArrayList<Node> nList) {
		if(graph.containsKey(p)) {
			ArrayList<Node> neigh_list_p = graph.get(p);
			for(int i=0; i < nList.size(); i++) {
				if(!graph.containsKey(nList.get(i))) {
					System.out.println("Node " + nList.get(i).getId() + " is not in graph");
				}
				else {
					neigh_list_p.add(nList.get(i));
					ArrayList<Node> neigh_list_n = graph.get(nList.get(i));
					neigh_list_n.add(p);
				}
			}
			
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public ArrayList<Node> getNeighboursOfNode(Node n) {
		if(graph.containsKey(n)) {
			return graph.get(n);
		}
		else {
			System.out.println("Node " + n.getId() + " is not in graph");
			return new ArrayList<Node>();
		}
	}
	
	public void deleteNeighbour(Node p, Node n) {
		if(graph.containsKey(p)) {
			if(graph.get(p).contains(n) && graph.get(n).contains(p)) {

				ArrayList<Node> neigh_list_p = graph.get(p);
				neigh_list_p.remove(n);
				ArrayList<Node> neigh_list_n = graph.get(n);
				neigh_list_n.remove(p);
			}
			else {
				System.out.println("Node " + p.getId() + " is not linked to node " + n.getId());
			}
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public void printNodes() {
		
		Iterator<HashMap.Entry<Node, ArrayList<Node>>> iter = graph.entrySet().iterator();
		while (iter.hasNext()) {
		    HashMap.Entry<Node, ArrayList<Node>> entry = iter.next();
		    Node newnode = entry.getKey();
		    ArrayList<Node> neigh_list = entry.getValue();
		    
		    System.out.print("Node " + newnode.getId() + " with neighbours: ");
		    for(int i=0; i<neigh_list.size(); i++) {
		    	System.out.print(neigh_list.get(i).getId() + " ");
		    }
		    System.out.println("");
		    
		}
	}

}
