import java.util.*;

public class SortedFreqs {
      public int[] freqs(String[] data) {
    	List<String> wordsList = new ArrayList<String>(Arrays.asList(data));
        Set<String> words = new TreeSet<String>(Arrays.asList(data));
        List<String> wordsNoDup = new ArrayList<String>(words);
        int[] freq = new int[words.size()];
        for(int i = 0; i < freq.length; i++){
        	freq[i] = Collections.frequency(wordsList, wordsNoDup.get(i));
        }
        return freq;
      }
   }