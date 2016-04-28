import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class GalaxyTrip {
	   private HashMap<Integer, HashSet<Integer>> depend;
	   private ArrayList<Integer> Size;
	   private HashSet<Integer> output;
	   private HashSet<Integer> visited;
	   private Integer count;
       public int[] possibleValues(String[] dependencies) {
    	   Size = new ArrayList<Integer>();
    	   visited = new HashSet<Integer>();
    	   output = new HashSet<Integer>();
    	   depend = new HashMap<Integer, HashSet<Integer>>();
    	   for(int i=0; i < dependencies.length; i++){
          	 depend.put(i, new HashSet<Integer>());
	         if(!dependencies[i].equals("")){
	          	 for(String machine : dependencies[i].split(" ")){
	          		 depend.get(i).add(Integer.parseInt(machine));
	          	 }
          	 }
           }
    	   for(int i=0; i < dependencies.length; i++){
    		   count = 0;
    		   if(depend.get(i).size() == 0)
    			   Size.add(1);
    		   else {
    			   if(!visited.contains(i)){
		    		   dfs(i);
		    		   Size.add(count);
	    		   }
    		   }
    	   }
    	   ArrayList<Integer> freq = new ArrayList<Integer>();
    	   for(int i = 0; i <= dependencies.length; i++){
    		   freq.add(Collections.frequency(Size, i));
    	   }
    	   count(freq, 0, 0);
    	   int[] possibleValues = new int[output.size()];
    	   int index = 0;
    	   for( Integer i : output) {
    		   possibleValues[index++] = i;
    	   }
    	   Arrays.sort(possibleValues);
    	   return possibleValues;
       }
       private void dfs(int i){
    	   if(visited.contains(i) || depend.get(i).size() == 0)
    		   return;
    	   count += 1;
    	   visited.add(i);
    	   for(int machine : depend.get(i))
    		   dfs(machine);
       }
       private void count(ArrayList<Integer> freq, int total, int pos){
    	   if(total != 0)
    		   output.add(total);//add one possible answer
    	   if(pos >= freq.size())
    		   return; 
    	   for(int i = 0; i <= freq.get(pos); i++)
    		   count(freq, total+i*pos, pos+1);
       }
   }