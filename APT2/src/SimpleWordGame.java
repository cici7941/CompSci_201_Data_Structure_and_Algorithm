
public class SimpleWordGame {
      public int points(String[] player, 
                        String[] dictionary) {
    	  int points = 0;
          for(int i = 0; i < dictionary.length; i++)
          {
        	  for(int j = 0; j < player.length; j++)
        	  {
        		  //begin help from http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        		  //I didn't know how to compare strings
        		  if(dictionary[i].equals(player[j]))
        		  //end help from http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java
        		  {
        			  points += Math.pow(dictionary[i].length(), 2);
        			  break;
        		  }
        	  }
          }
          return points;
      }
  }
