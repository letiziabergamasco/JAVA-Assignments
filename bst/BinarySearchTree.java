package bst;

public class BinarySearchTree {
	
	//constructors
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public BinarySearchTree(int root_key, int root_value) {
		this.root = new Node(root_key, root_value);
	}
	
	
	private Node root;
	
	
	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	//insert a node
	public void insert(Node root, int key, int value) {
		
		if(root==null) {
			root = new Node(key, value);
			return;
		}
		
		//if the key already exists, that node is updated
		if(findNodeByKey(key)!= null) {
			update(key, value);
			return;
		}
			
		Node current = root;
		
		while(current != null) {
			
			if(key < current.getKey()) {
				if(current.getLhs() == null) {
					current.setLhs(new Node(key, value));
					return;
				}
				current = current.getLhs();	
			}
			else {
				if(current.getRhs() == null) {
					current.setRhs(new Node(key, value));
					return;
				}
				current = current.getRhs();	
				
			}
				
		}
	}
	
	
	//return value corresponding to a given key
	public int findValueByKey(int key){
		
		Node current = this.root;
		
		while(current!=null){
			
			if(current.getKey() == key){
				return current.getValue();
			}else if(key < current.getKey()){
				current = current.getLhs();
			}else{
				current = current.getRhs();
			}
		}
		return -1;
	}
	
	
	//update the value of a node
	public void update(int key, int new_value) {
		
		Node current = findNodeByKey(key);
		
		if(current == null)
			System.out.println("Node not found");
		else
			current.setValue(new_value);
		
	}
	
	//print all the nodes
	public void printNodes(Node root) {
		if(root != null) {
			System.out.println("Node " + root.getKey() + " with value " + root.getValue());
			printNodes(root.getLhs());
			printNodes(root.getRhs());
		}
	}

	
	//delete a node (recursive)
	public void delete(Node root, int key) {
			
			root = deleteNode(root, key);
		}
		
		private Node deleteNode(Node root, int key) {
			
			if(root == null) //it stops when it finds null
				return root;
			if(key < root.getKey())
				root.setLhs(deleteNode(root.getLhs(), key)); //recur left
			else if(key > root.getKey())
				root.setRhs(deleteNode(root.getRhs(),key)); //recur right
			else { //node to be deleted has been found
				
				//one child => update links, no children => just delete
				if(root.getLhs() == null)
					return root.getRhs();
				if(root.getRhs() == null)
					return root.getLhs();
				
				//two children => find successor to replace node to be deleted
				Node successor = successor(root, root);
	
				root.setKey(successor.getKey());
				root.setValue(successor.getValue());
				
				//delete successor
				root.setRhs(deleteNode(root.getRhs(), root.getKey()));
				 
			}
			
			return root;
		}
		
	
	
	private Node findNodeByKey(int key){
		
		Node current = this.root;
		
		while(current!=null){
			
			if(current.getKey() == key){
				return current;
			}else if(key < current.getKey()){
				current = current.getLhs();
			}else{
				current = current.getRhs();
			}
		}
		return null;
	}
	
	
	private Node successor (Node n, Node root) {
		
		//minimum of the right subtree
		if(n.getRhs()!=null) {
			return minimum(n.getRhs());
		}
			
		//look for the first parent for which n is in the left subtree
		Node successor = parent(n, root);
		Node current = n;
		while(successor != null && (successor.getRhs().getKey() == current.getKey())) {
			current = successor;
			successor = parent (current, root);
		}
		
		return successor;
		
		
	}
	
	private Node minimum (Node root) {
		
		Node current = root;
		while(current.getLhs()!=null) {
			current =  current.getLhs();
		}
		return current;
	}
	
	private Node parent (Node n, Node root) {
		
		if(n.getKey() == this.root.getKey())
			return null;
		
		Node parent = null;
		Node current = root;
		boolean found = false;
		
		while(found==false && current!= null){
					
					if(current.getKey() == n.getKey()){
						found = true;
						return parent;
					}else if(n.getKey() < current.getKey()){
						parent = current;
						current = current.getLhs();
					}else{
						parent = current;
						current = current.getRhs();
					}
		}
		return null;
		
	}
	
	
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree(10, 10);
		System.out.println("Root has been inserted with key " + bst.getRoot().getKey());
		System.out.println("");
		
		bst.insert(bst.getRoot(), 5, 5);
		bst.insert(bst.getRoot(), 14, 14);
		bst.insert(bst.getRoot(), 21, 21);
		bst.insert(bst.getRoot(), 1, 1);
		bst.insert(bst.getRoot(), 8, 8);
		bst.insert(bst.getRoot(), 3, 3);
		bst.insert(bst.getRoot(), 6, 6);
		bst.insert(bst.getRoot(), 9, 9);
		
		System.out.println("These nodes have been inserted:");
		bst.printNodes(bst.getRoot());
		System.out.println("");
		
		bst.insert(bst.getRoot(), 1, 99); //Node 1 is updated
		System.out.println("These nodes have been inserted:");
		bst.printNodes(bst.getRoot());
		System.out.println("");
		
		bst.delete(bst.getRoot(), 10);
		System.out.println("Node 10 has been deleted, now the nodes are:");
		bst.printNodes(bst.getRoot());
		
		System.out.println("The new root is");
		System.out.println(bst.getRoot().getKey());
		System.out.println("");
		
		bst.delete(bst.getRoot(), 5);
		System.out.println("Node 5 has been deleted, now the nodes are:");
		bst.printNodes(bst.getRoot());
		
		
	}
	

}
