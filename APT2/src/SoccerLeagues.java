
public class SoccerLeagues {
     public int[] points(String[] matches) {
         int[] points = new int[matches.length];
         for(int i = 0; i < points.length; i++)
         {
        	 for(int j=0; j < points.length; j++)
        	 {
        		 if(matches[i].charAt(j) == 'W') // team i wins as a home team
        		 {
        			 points[i] += 3;
        		 }
        		 if(matches[i].charAt(j) == 'D') // there is a draw
        		 {
        			 points[i] += 1;
        			 points[j] += 1;
        		 }
        		 if(matches[j].charAt(i) == 'L') // team i wins as a away team
        		 {
        			 points[i] += 3;
        		 }
        	 }
         }
         return points;
     }
 }
