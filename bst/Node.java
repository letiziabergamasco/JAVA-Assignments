package bst;

public class Node {
	
	private int key;
	private int value;
	
	private Node lhs;
	private Node rhs;
	
	//constructors
	public Node() {
		this.lhs = null;
		this.rhs = null;
	}
	
	public Node(int key, int value) {
		this.lhs = null;
		this.rhs = null;
		this.key = key;
		this.value = value;
	}
	

	//getters and setters
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLhs() {
		return lhs;
	}

	public void setLhs(Node lhs) {
		this.lhs = lhs;
	}

	public Node getRhs() {
		return rhs;
	}

	public void setRhs(Node rhs) {
		this.rhs = rhs;
	}
	
	

}