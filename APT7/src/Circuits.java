import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Circuits {

	private int mySize; 		// Number of vertices
	private int myGraph[][];	// Adjacency matrix
	private int myIn[];			// In-degree of each vertex
	
	
	public int howLong(String[] connects, String[] costs) {
		buildGraph(connects, costs);	// build adjacency matrix
		// visualize();					// visualize adjacency matrix
		return search();				// BFS/DFS/other search
    }

	// Build the adjacency matrix representation
	public void buildGraph(String[] connects, String[] costs) {
		mySize = connects.length;
		myGraph = new int[mySize][mySize];
		myIn = new int[mySize];
		
		// Go through the input
		// if there are any connection from "fromV"
		// then add myGraph[fromV][toV] with the correct weight and increment myIn[toV]
		for (int fromV = 0; fromV < mySize; fromV++) {
			if (!connects[fromV].equals("")) {
				String[] edges = connects[fromV].split(" ");
				String[] weights = costs[fromV].split(" ");
				for (int i=0; i<edges.length; i++) {
					int toV = Integer.parseInt(edges[i]);
					myGraph[fromV][toV] = Integer.parseInt(weights[i]);
					myIn[toV]++;		
				}
			}
		}
		return;
	}

	// Help visualize the adjacency matrix myGraph and the In Degrees myIn
	public void visualize() {
		// print the adjacency matrix
		for (int fromV = 0; fromV < mySize; fromV++) {
			for (int toV = 0; toV < mySize; toV++) {
				System.out.print(myGraph[fromV][toV] + " ");
			}
			System.out.println();
		}
	
		// print the inDegrees
		for (int toV = 0; toV < mySize; toV++) {
			System.out.print(myIn[toV] + " ");
		}
		System.out.println("<< InDegrees");
		System.out.println();
		return;	
	}
	
	// BFS or DFS
	private int search() {
		int[] distance =  new int[mySize]; // Distance to vertex i 

		// Data structure to track search
		Queue<Integer> q = new LinkedList<Integer>();
		//			OR
		// Stack<Integer> q = new Stack<Integer>();
		
		// Add all the "roots" (InDegree is 0)
		for (int v=0; v < mySize; v++) {
			if (myIn[v]==0) {
				q.add(v);
			}
		}
		
		// Remove each item until nothing left 
		// While queue/stack is not empty
		while (!q.isEmpty()) {
			// get the next element
			int fromV = q.poll();
			// OR 
			// int fromV = q.pop();
			
			// Check all possible connections
			// start with default weight in myGraph[fromV][toV]
			// Update weights if longer path is found using BFS/DFS
			for (int toV = 0; toV < mySize; toV++) {
				int weight = myGraph[fromV][toV];
				if (weight > 0) {
					distance[toV] = 
						Math.max(distance[toV], distance[fromV]+weight);
					myIn[toV]--;
					if (myIn[toV] == 0) {
						q.add(toV);
					}
				}
			}
			
		}
		
		// Get the max distance to any vertex
		int max = 0;
		for (int iDistance : distance) {
			max = Math.max(max, iDistance);
		}
		
		return max;
	}


}
