import java.util.ArrayList;
import java.util.HashMap;

public class DrawTree {
	ArrayList<String> nameTree = new ArrayList<String>();
      public String[] draw(int[] parents, String[] names) {
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=-1; i<names.length; i++){
        	ArrayList<Integer> child = new ArrayList<Integer>();
        	for(int j=0; j<parents.length; j++){
        		if(parents[j] == i){
        			child.add(j);
        		}
        	}
        	tree.put(i, child);
        }
        for(int i=0; i<tree.get(-1).size(); i++){
        	int children = tree.get(-1).get(i);
        	boolean havesib = i<tree.get(-1).size()-1;
        	nameTree.add("+-"+names[children]);
        	String space = "";
        	draw(tree, children, names, space, havesib);
        }
        String[] nameTreeArray = new String[nameTree.size()];
        return nameTree.toArray(nameTreeArray);
      }
      private void draw(HashMap<Integer, ArrayList<Integer>> tree, Integer index, String[] names,String space, boolean havesib){
    	  if(tree.get(index)==null){
    		  return;
    	  }
    	  if(havesib) space += "| ";
    	  else space += "  ";
    	  for(int i=0; i<tree.get(index).size(); i++){
    		  int children = tree.get(index).get(i);
    		  havesib = i<tree.get(index).size()-1;
    		  nameTree.add(space+"+-"+names[children]);
    		  draw(tree, children, names, space, havesib);
    	  }
      }
   }