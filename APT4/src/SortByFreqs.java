import java.util.*;

public class SortByFreqs {
      public String[] sort(String[] data) {
    	  List<String> wordsList = new ArrayList<String>(Arrays.asList(data));
          class AlphaFreq implements Comparator<String>{
        	 public int compare(String o1, String o2){
        		 if(Collections.frequency(wordsList, o1) != Collections.frequency(wordsList, o2)){
        			 return Collections.frequency(wordsList,o2)-Collections.frequency(wordsList,o1);
        		 }
        		 return o1.compareTo(o2);
        	 }
          }
          Set<String> dataSet = new HashSet<String>(Arrays.asList(data));
          String[] noDup = new String[dataSet.size()];
    	  dataSet.toArray(noDup);         
          Arrays.sort(noDup, new AlphaFreq());
          return noDup;
      }
   }