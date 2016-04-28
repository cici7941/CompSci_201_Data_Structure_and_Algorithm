import java.util.HashMap;
import java.util.HashSet;

public class Internet {
	 private HashSet<Integer> visited;
	 private HashMap<Integer, HashSet<Integer>> connect;
     public int articulationPoints(String[] routers) {
    	 connect = new HashMap<Integer, HashSet<Integer>>();
         int num = 0; //count the number of articulation points
         //construct HashMap to store connected routers
         for(int i=0; i < routers.length; i++){
        	 connect.put(i, new HashSet<Integer>());
        	 for(String router : routers[i].split(" ")){
        		 connect.get(i).add(Integer.parseInt(router));
        	 }
         }
         //loop over the routers, remove a router once
         for(int remove = 0; remove < routers.length; remove++){
        	 visited = new HashSet<Integer>();
        	 int start = connect.get(remove).iterator().next();
        	 //search for connected routers after removing a router
        	 dfs(routers, remove, start);
        	 if(visited.size() < routers.length-1)
        		 num += 1;
         }
         return num;
     }
     private void dfs(String[] routers, int remove, int start){
    	 if(visited.contains(start))
    		 return;
    	 visited.add(start);
    	 for(int router : connect.get(start)){
    		 if(router != remove && !visited.contains(router))
    			 dfs(routers, remove, router);
    	 } 
     }
  }