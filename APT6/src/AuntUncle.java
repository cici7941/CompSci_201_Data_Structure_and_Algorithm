import java.util.ArrayList;
import java.util.Arrays;

public class AuntUncle {
       public String[] list(String[] parents, String target) {
    	   ArrayList<String> parentList = new ArrayList<String>();
    	   ArrayList<String> grandParentList = new ArrayList<String>();
    	   ArrayList<String> auntUncleList = new ArrayList<String>();
    	   
    	   // find target's parents
           for(String parent : parents){
        	   String[] family = parent.split(" ");
        	   if(family[2].equals(target)){
        		   parentList.add(family[0]);
        		   parentList.add(family[1]);
	        	   break;
        	   }
           }
           
           // find target's grandparents
           for(String parent : parents){
        	   String[] family = parent.split(" ");
        	   if(parentList.contains(family[2])){
	        	   grandParentList.add(family[0]);
	        	   grandParentList.add(family[1]);
        	   }
           }
           
           //find target's uncles and aunts
           for(String parent : parents){
        	   String[] family = parent.split(" ");
        	   if((grandParentList.contains(family[0]) || grandParentList.contains(family[1])) && !parentList.contains(family[2]) && !family[2].equals(target)){
        		   auntUncleList.add(family[2]);
        	   }
           }
           
           String[] auntUncle = new String[auntUncleList.size()];
           auntUncleList.toArray(auntUncle);
           Arrays.sort(auntUncle);
           return auntUncle;
       }
   }