import java.util.HashMap;
import java.util.HashSet;

public class FriendScore {
      public int highestScore(String[] friends) {
    	 HashMap<Integer, HashSet<Integer>> friendScore = new HashMap<Integer, HashSet<Integer>>();
         for(int i = 0; i < friends.length; i++){
        	 friendScore.put(i, new HashSet<Integer>());
        	 for(int j = 0; j < friends[i].length(); j++){
        		 //add friend
        		 if(friends[i].charAt(j) == 'Y')
        			 friendScore.get(i).add(j);
        		 //add 2friend
        		 for(int k = 0; k < friends.length; k++){
        			 if(i!=j && friends[i].charAt(k) == 'Y' && friends[j].charAt(k) == 'Y')
        				 friendScore.get(i).add(j);
        		 }
        	 }
         }
         int highestScore = 0;
         for(Integer person : friendScore.keySet()){
        	 if(friendScore.get(person).size() > highestScore)
        		 highestScore = friendScore.get(person).size();
         }
         return highestScore;
      }
   }