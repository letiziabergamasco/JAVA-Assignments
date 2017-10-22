package graphs;
public class Edge {
	
	private Node destination;
	private String label;
	
	public Edge(Node dest, String lab) {
		this.destination = dest;
		this.label = lab;
	}
	
	public Node getDestination() {
		return destination;
	}
	public void setDestination(Node destination) {
		this.destination = destination;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	

}
