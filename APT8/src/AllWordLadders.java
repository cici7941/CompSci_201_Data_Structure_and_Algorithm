import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class AllWordLadders {
      public int[] solve(String[] words,  String from, String to) {
    	//constructing the graph
      	HashMap<String, HashSet<String>> myGraph = new HashMap<String, HashSet<String>>();
      	myGraph.put(from, new HashSet<String>());
      	myGraph.put(to, new HashSet<String>());
      	for(String word : words){
      		myGraph.put(word, new HashSet<String>());
      		if(isNext(from, word)){
      			myGraph.get(from).add(word);
      			myGraph.get(word).add(from);
      		}
      		if(isNext(word, to)){
  				myGraph.get(word).add(to);
      			myGraph.get(to).add(word);
      		}
      		for(String word2 : words){
      			if(!word2.equals(word) && isNext(word, word2))
      				myGraph.get(word).add(word2);
      		}
      	}
      	//constructing HashMap to store distance
    	HashMap<String, Integer> dist = new HashMap<String, Integer>();
    	dist.put(from, 1);
      	//constructing a HashMap to count the number of shortest paths
      	HashMap<String, Integer> shortestPaths = new HashMap<String, Integer>();
      	shortestPaths.put(from, 1);
      	//creating a queue of vertices
      	LinkedList<String> Q = new LinkedList<String>();
      	//creating a set of visited vertices
      	HashSet<String> S = new HashSet<String>();
      	Q.add(from);
      	//using BFS to find if there is a path 
      	while(!Q.isEmpty()){
      		String current = Q.pop();
      		if(!S.contains(current)){
  	    		S.add(current);
  	    		int sum = 0;
  	    		for(String neighbor : myGraph.get(current)){
  	    			if(!dist.containsKey(neighbor)){
	    				dist.put(neighbor, dist.get(current)+1);
	    				Q.add(neighbor);
	    			}
    				if(dist.get(neighbor) == dist.get(current)-1)
    					sum += shortestPaths.get(neighbor);
  	    		}
  	    		if(!shortestPaths.containsKey(current))
	    				shortestPaths.put(current, sum);
      		}
      	}
      	if(!dist.containsKey(to)){
      		int[] output = {0,0};
      		return output;
      	}
      	int[] output1 = {dist.get(to), shortestPaths.get(to)};
      	return output1;
      }
      //helper method
      //return true if there is only 1 letter difference
      private boolean isNext(String from, String to){
      	int numDiff = 0;
      	for(int i = 0; i < from.length(); i++){
      		if(from.charAt(i) != to.charAt(i))
      			numDiff++;
      	}
      	if(numDiff == 1)
      		return true;
      	return false;
      }
   }