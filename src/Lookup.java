import java.util.ArrayList;

public class Lookup {

	int key; 
	Node startNode;
	private Node[] nodes;
	private ArrayList<Node> routedNodes = new ArrayList<>(); 
	
	public Lookup(int key) {
		this.key = key;
	}
	
	public void nodeArray(Node[] nodes) {
		this.nodes = nodes; 
	}
	
	public void searchKValues(Node node) {
		this.startNode = node;

		routedNodes.add(startNode);
		
		for(int i = 0; i < startNode.kValues.length; i++) {
			
			
			if(key < startNode.kValues[0]) {
				break;
			
			} else if(i == startNode.kValues.length-1){
				startNode.setFlag(true);
				startNode = startNode.getMappedNodes(i);
				searchKValues(startNode);
			
			} else if(key <= startNode.kValues[i]) {
				startNode.setFlag(true);
				startNode = startNode.getMappedNodes(i-1);
				searchKValues(startNode);
				
			} else if(key > nodes[nodes.length-1].nodeID && startNode.getFlag() == true) {
				break; 
			}
		}
	}
	
	public void printRoutedNodes(Node node) {
		System.out.println("StartNode :: " + node.toString());
		System.out.println("");
		System.out.print("Nodes Visited :: ");
		for(Node k : routedNodes) {
			System.out.print(k.toString() + "\t");
		}
		System.out.println("");
		for(Node n : routedNodes) {
			System.out.println("");
			n.printFingerTable();
		}
	}
	

	
	
	
	
	
	
	
	
	
}
