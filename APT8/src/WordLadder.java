import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {
    public String ladderExists(String[] words, 
                               String from, String to) {
    	//constructing the graph
    	HashMap<String, HashSet<String>> myGraph = new HashMap<String, HashSet<String>>();
    	myGraph.put(from, new HashSet<String>());
    	for(String word : words){
    		myGraph.put(word, new HashSet<String>());
    		if(isNext(from, word))
    			myGraph.get(from).add(word);
    		if(isNext(word, to))
				myGraph.get(word).add(to);
    		for(String word2 : words){
    			if(!word2.equals(word) && isNext(word, word2))
    				myGraph.get(word).add(word2);
    		}
    	}
    	//creating a queue of vertices
    	LinkedList<String> Q = new LinkedList<String>();
    	//creating a set of visited vertices
    	HashSet<String> S = new HashSet<String>();
    	Q.add(from);
    	//using BFS to find if there is a path 
    	while(!Q.isEmpty()){
    		String current = Q.pop();
    		if(current.equals(to))
    			return "ladder";
    		if(!S.contains(current)){
	    		S.add(current);
	    		for(String neighbor : myGraph.get(current))
	    			Q.add(neighbor);
    		}
    	}
    	return "none";
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
