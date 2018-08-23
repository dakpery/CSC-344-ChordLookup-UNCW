
public class Node 
{
	private Node successor;
	private Node predecessor;
	public int nodeID; 
	public int[] kValues; 
	private Node[] nodes; 
	private int newMax;  
	private Node[] mappedNodes; 
	private boolean flag; 
	
	public Node(int nodeID, int B) {
		this.nodeID = nodeID; 
		double maxValue = Math.pow(2, B); 
		newMax = (int) Math.round(maxValue); 
	}
	
	
	public void fingerTable() {  
		kValues = new int[6];
		int mult = 1; 
		for(int i = 0; i < kValues.length; i++) {
			int kValue = nodeID + mult;
			//if(kValue > newMax)
			if(kValue > nodes[nodes.length-1].nodeID && kValue > newMax)
			{
				kValue = kValue - newMax; 
			}
			kValues[i] = kValue;
			mult = mult*2;
		}
	}
	
	public void mapKValues() {
		mappedNodes = new Node[kValues.length];
		for(int i = 0; i < kValues.length; i++) {
			for(int j = 0; j < nodes.length; j++) {
				if(kValues[i] <= nodes[j].nodeID) {
					mappedNodes[i] = nodes[j];
					break;
				} else if(kValues[i] > nodes[nodes.length-1].nodeID) {
					mappedNodes[i] = nodes[0];
				}
			}
		}
	}
	
	public void printMappedValues() {

		System.out.println("NodeID :: " + nodeID);
		for(int i = 0; i < mappedNodes.length; i++) {
			System.out.print("\t" + mappedNodes[i].toString()+ " ");
		}
		System.out.println("");

	}
	
	public void printFingerTable() {
		System.out.println("NodeID :: "+ nodeID + "\tK Values" + "\tMapped Node");
		for(int i = 0; i < kValues.length; i++) {
			System.out.print("\t\t"+kValues[i]);
			System.out.print("\t\t"+mappedNodes[i]);
			System.out.println("");
		}
			
		System.out.println("");
	}
	
	
	public String toString() {
		return "N" + nodeID; 
	}
	
	public void setArray(Node[] nodes) {
		this.nodes = nodes; 
	}
	
	public void setSucessor(Node suc) {
		this.successor = suc; 
	}
	
	public void setPredessocor(Node ped) {
		this.predecessor = ped; 
	}
	
	public void printSuc() {
		 System.out.print("\t" + "Success = "+ successor); 
	}
	
	public void printPre() {
		System.out.print("\t" + "Pred = " + predecessor); 
	}
	
	public Node getMappedNodes(int i) {
		return mappedNodes[i];
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag; 
	}
	
	public boolean getFlag() {
		return flag; 
	}
	

	


}
