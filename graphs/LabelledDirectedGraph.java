package graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LabelledDirectedGraph {
	
	private HashMap< Node, ArrayList<Edge> > graph = new HashMap<Node, ArrayList<Edge>>();
	
	public LabelledDirectedGraph() {}
	
	public void addNode(Node n) {
		if(!graph.containsKey(n)) {
			graph.put(n, new ArrayList<Edge>());
		}
		else {
			System.out.println("Node " + n.getId() + " is already in graph");
		}
	}
	
	public void addEdge(Node p, Edge e) {
		if(graph.containsKey(p)) {
			if(!graph.containsKey(e.getDestination())) {
				System.out.println("Node " + e.getDestination().getId() + " is not in graph");
				return;
			}
			ArrayList<Edge> neigh_list = graph.get(p);
			neigh_list.add(e);
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public void addEdgesList(Node p, ArrayList<Edge> eList) {
		if(graph.containsKey(p)) {
			ArrayList<Edge> neigh_list = graph.get(p);
			for(int i=0; i < eList.size(); i++) {
				if(!graph.containsKey(eList.get(i).getDestination())) {
					System.out.println("Node " + eList.get(i).getDestination().getId() + " is not in graph");
				}
				else {
					neigh_list.add(eList.get(i));
				}
			}
			
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public ArrayList<Edge> getEdgesOfNode(Node n) {
		if(graph.containsKey(n)) {
			return graph.get(n);
		}
		else {
			System.out.println("Node " + n.getId() + " is not in graph");
			return new ArrayList<Edge>();
		}
	}
	
	public void deleteEdge(Node p, Edge e) {
		if(graph.containsKey(p)) {
			if(graph.get(p).contains(e)) {
				ArrayList<Edge> neigh_list = graph.get(p);
				neigh_list.remove(e);
			}
			else {
				System.out.println("Node " + p.getId() + " is not linked to node " + e.getDestination().getId());
			}
		}
		else {
			System.out.println("Node " + p.getId() + " is not in graph");
		}
	}
	
	public void printNodes() {
		
		Iterator<HashMap.Entry<Node, ArrayList<Edge>>> iter = graph.entrySet().iterator();
		while (iter.hasNext()) {
		    HashMap.Entry<Node, ArrayList<Edge>> entry = iter.next();
		    Node newnode = entry.getKey();
		    ArrayList<Edge> neigh_list = entry.getValue();
		    
		    System.out.print("Node " + newnode.getId() + " with neighbours: ");
		    for(int i=0; i<neigh_list.size(); i++) {
		    	System.out.print(neigh_list.get(i).getDestination().getId() + " ");
		    	System.out.print(neigh_list.get(i).getLabel() + "; ");
		    }
		    System.out.println("");
		    
		}
	}

}
