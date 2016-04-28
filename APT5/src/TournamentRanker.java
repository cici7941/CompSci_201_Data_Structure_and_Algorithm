import java.util.*;
public class TournamentRanker  {  
	public String[] rankTeams(String[] names, String[] lostTo) {
		HashMap<String, Integer> wins = new HashMap<String, Integer>();
	  	for(String name : names){
	  		int count = 0;
	  		for(String lost : lostTo){
	  			if(name.equals(lost)){
	  				count++;
	  			}
	  		}
	  		wins.put(name, count);
	  	} 
	  	HashMap<String, String> lost = new HashMap<String, String>();
	  	for(int i=0; i<names.length; i++){
	  		lost.put(names[i],lostTo[i]);
	  	} 
		class Rank implements Comparator<String>{
			public int compare(String o1, String o2){
				if(wins.get(o1)!=wins.get(o2)){
					return wins.get(o2)-wins.get(o1);
				}
				return compare(lost.get(o1), lost.get(o2));
			}
		}
		Arrays.sort(names, new Rank());
		return names;
	}
}