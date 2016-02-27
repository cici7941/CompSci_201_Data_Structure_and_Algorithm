import java.util.*;

public class SyllableSorting {
    public String[] sortWords(String[] words) {
    	Arrays.sort(words, new newOrder());
    	return words;
    }
    public String[] unsorted(String word){
    	List<String> list = new ArrayList<String>();
        String s = "" + word.charAt(0);
        for(int i = 1; i < word.length(); i++){
            if(Character.toString(word.charAt(i-1)).matches("[aeiou]")&&
                    Character.toString(word.charAt(i)).matches("[^aeiou]")){
                list.add(s);
                s = "" + word.charAt(i);
            } else {
                s += word.charAt(i);
            }
        }
        list.add(s);
        String[] unsort = new String[list.size()];
        return list.toArray(unsort);
    }
    public String[] sorted(String word){
    	String[] reorder = unsorted(word);
        Arrays.sort(reorder);
        return reorder;
    }
    class newOrder implements Comparator<String>{
        public int compare(String o1, String o2){
            if(!Arrays.equals(sorted(o1), sorted(o2))){
                for(int i = 0; i<Math.min(sorted(o1).length, sorted(o2).length); i++){
                	if(!sorted(o1)[i].equals(sorted(o2)[i])){
                		return sorted(o1)[i].compareTo(sorted(o2)[i]);
                	}
                }
                return sorted(o1).length - sorted(o2).length;
            } else {
            	for(int i = 0; i<Math.min(unsorted(o1).length, unsorted(o2).length); i++){
                	if(!Arrays.equals(unsorted(o1), unsorted(o2))){
                		return unsorted(o1)[i].compareTo(unsorted(o2)[i]);
                	}
                }
                return unsorted(o1).length - unsorted(o2).length;
            }
        }
    }
}