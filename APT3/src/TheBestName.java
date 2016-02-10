import java.util.Comparator;
import java.util.Arrays;

public class TheBestName { 
	public class Sorter implements Comparator<String>{
		public int compare(String a, String b){
		    if(a.equals("JOHN")){
		    	return -1;
		    } 
		    else if(b.equals("JOHN")){
		    	return 1;
		    }
			else if(weight(a) != weight(b)){
				return weight(b) - weight(a);
			} else
				return a.compareTo(b);
		}
	}
	public int weight(String name){
		   int weight = 0;
		   for(int i = 0; i < name.length(); i++){
			   weight += ((int)name.charAt(i) - 64);
		   }
		   return weight;
	 }
	public String[] sort(String[] names) { 
		Arrays.sort(names, new Sorter());
		return names;
	}
}