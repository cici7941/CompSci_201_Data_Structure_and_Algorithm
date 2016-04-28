import java.util.*;

public class ErdosNumber {
    public String[] calculateNumbers(String[] pubs) {
      //constructing the graph
    	HashMap<String, HashSet<String>> myGraph = new HashMap<String, HashSet<String>>(); 
    	for(String publication: pubs){
    		String[] authors = publication.split(" ");
    		for(String author : authors){
    			if(!myGraph.containsKey(author))
    				myGraph.put(author, new HashSet<String>()); 
    			for(String author2 : authors){
    				if(!author2.equals(author))
    					myGraph.get(author).add(author2);
    			}
    		}
    	}
    	//constructing HashMap to store distance
    	HashMap<String, Integer> dist = new HashMap<String, Integer>();
    	dist.put("ERDOS", 0);
    	//creating a queue of vertices
    	LinkedList<String> Q = new LinkedList<String>();
    	//creating a set of visited vertices
    	HashSet<String> S = new HashSet<String>();
    	Q.add("ERDOS");
    	//using BFS to calculate the distance
    	while(!Q.isEmpty()){
    		String current = Q.pop();
    		if(!S.contains(current)){
	    		S.add(current);
	    		for(String neighbor : myGraph.get(current)){
	    			if(!dist.containsKey(neighbor)){
	    				dist.put(neighbor, dist.get(current)+1);
	    				Q.add(neighbor);
	    			}
	    		}
    		}
    	}
    	//constructing the output in the correct format
    	String[] authors = new String[myGraph.size()];
    	myGraph.keySet().toArray(authors);
    	String[] output = new String[authors.length];
    	for(int i = 0; i < output.length; i++){
    		if(dist.get(authors[i]) == null)
    				output[i] = authors[i];
    		else
    			output[i] = authors[i] + " " + dist.get(authors[i]);
    	}
    	Arrays.sort(output);
    	return output;
    }
  }
