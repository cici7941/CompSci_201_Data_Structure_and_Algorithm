import java.util.*;

public class MemberCheck {
      public String[] whosDishonest(String[] club1, 
                                    String[] club2, 
                                    String[] club3) {
    	  Set<String> club1Set = new HashSet<String>(Arrays.asList(club1));
    	  Set<String> club2Set = new HashSet<String>(Arrays.asList(club2));
    	  Set<String> club3Set = new HashSet<String>(Arrays.asList(club3));
    	  Set<String> clubSet = new HashSet<String>();
    	  clubSet.addAll(club1Set);
    	  clubSet.addAll(club2Set);
    	  clubSet.addAll(club3Set);
    	  TreeMap<String, Integer> counts = new TreeMap<String, Integer>();
    	  for(String member:clubSet){
    		  int count = 0;
    		  if(club1Set.contains(member)){
    			  count++;
    		  }
    		  if(club2Set.contains(member)){
    			  count++;
    		  }
    		  if(club3Set.contains(member)){
    			  count++;
    		  }
    		  counts.put(member, count);
    	  }
    	  List<String> dishonest = new ArrayList<String>();
    	  for(String member : counts.keySet()){
    		  if(counts.get(member)>1){
    			  dishonest.add(member);
    		  }
    	  }
    	  String[] dishonest1 = new String[dishonest.size()];
    	  return dishonest.toArray(dishonest1);
      }
   }