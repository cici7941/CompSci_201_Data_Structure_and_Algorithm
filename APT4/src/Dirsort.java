import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
     public String[] sort(String[] dirs) {
          class AlphaLength implements Comparator<String>{
        	  public int compare(String o1, String o2){
        		  String[] o1Array = o1.split("/");
        		  String[] o2Array = o2.split("/");
        		  if(o1Array.length != o2Array.length){
        			  return o1Array.length - o2Array.length;
        		  }
        		  return o1.compareTo(o2);
        	  }
          }
		Arrays.sort(dirs, new AlphaLength());
		return(dirs);
     }
  }