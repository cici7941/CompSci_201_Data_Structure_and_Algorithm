
public class IsomorphicWords {
      public int countPairs(String[] words) {
    	  int countPairs = 0;
    	  for(int i = 0; i < words.length; i++){
    		  for(int j = i+1; j < words.length; j++){
    			  if(isomorphic(words[i], words[j])){
    				  countPairs++;
    			  }
    		  }
    	  }
    	  return countPairs;
      }
      public boolean isomorphic(String word1, String word2){
    	  if(pattern(word1).equals(pattern(word2))){
    	  return true;
    	  } else {
    		  return false;
    	  }
      }
      public String pattern(String word){
    	  String pattern = "a";
    	  int j = 'a';
    	  for(int i = 1; i < word.length(); i++){
    		  if(word.substring(0,i).indexOf(word.charAt(i)) < 0){
    			  j++;
    			  pattern += (char) j;
    		  } else {
    			  pattern += pattern.charAt(word.substring(0,i).indexOf(word.charAt(i)));
    		  }
    	  }
    	  return pattern;
      }
   }