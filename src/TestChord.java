import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestChord 
{

	
	int N; 
	int newMax; 
	int B; 
	int key; 
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an integer B :: ");
		this.B = sc.nextInt(); 
		
		System.out.print("Please enter an integer N :: ");
		this.N = sc.nextInt();
	}
	
	
	public int[] stepOne() {	
		double maxValue = (int)Math.pow(2, B);
		this.newMax = (int) Math.round(maxValue); 
		
		
		int nodeIDArray[] = new int[N];
		
		for(int i = 0; i < nodeIDArray.length; i++)
		{		
			int randomNum = ThreadLocalRandom.current().nextInt(1, newMax);
			for(int j = 0; j < nodeIDArray.length; j++) {
				if(nodeIDArray[j] == randomNum) {
					randomNum = ThreadLocalRandom.current().nextInt(1, newMax);
				}
			}
			nodeIDArray[i] = randomNum; 
		}
	
		Arrays.sort(nodeIDArray);
		
		return nodeIDArray; 
	}
	
	
	public void stepTwo(int[] nodeIDArray) {
		
		Node nodeArray[] = new Node[N]; 
		
		key = ThreadLocalRandom.current().nextInt(1, newMax);
		boolean done = false; 
		while(!done)
		{
			while(key <= nodeIDArray[0]) {
				key = ThreadLocalRandom.current().nextInt(1, newMax);
			}
			done = true; 
		}

		System.out.println("");
		System.out.print("Created Nodes :: ");
		
		for(int i = 0; i < nodeArray.length; i++)
		{
			Node newNode = new Node(nodeIDArray[i],B);
			nodeArray[i] = newNode; 
			System.out.print(newNode.toString() + "\t");
		}
		System.out.println("");

		
		for(int i = 0; i < nodeArray.length; i++) {
			nodeArray[i].setArray(nodeArray);
			nodeArray[i].fingerTable();
		}
		
		for(int i = 0; i < nodeArray.length; i++)
		{
			Node tempNode = nodeArray[i];

			if(nodeArray.length == 1) {
				tempNode.setPredessocor(tempNode);
				tempNode.setSucessor(tempNode);
				break;
			}
			if(i == 0) {
				tempNode.setPredessocor(nodeArray[nodeArray.length-1]);
				tempNode.setSucessor(nodeArray[i+1]);
			}
			else if (i == nodeArray.length-1) {
				tempNode.setPredessocor(nodeArray[i-1]);
				tempNode.setSucessor(nodeArray[0]);
			}
			else {
				tempNode.setPredessocor(nodeArray[i-1]);
				tempNode.setSucessor(nodeArray[i+1]);
			}
		}

		
		for(int i = 0; i < nodeArray.length; i++) {
			nodeArray[i].setArray(nodeArray);
			nodeArray[i].mapKValues();

		}		
		
		Lookup chord = new Lookup(key);
		chord.nodeArray(nodeArray);
		
		System.out.println("");
		System.out.println("Key :: " + key);
		chord.searchKValues(nodeArray[1]);
		System.out.println("");
		chord.printRoutedNodes(nodeArray[1]);
	}
	
	
	
	
	public TestChord() {
		input();
		stepOne();
		stepTwo(stepOne());
	}
	
	
	public static void main(String[] args) {
		TestChord tc = new TestChord(); 
	}

			

	
	
}
