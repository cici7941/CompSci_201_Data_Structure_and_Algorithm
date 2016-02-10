import java.util.ArrayList;
import java.util.Arrays;

public class ClassScores {
   public int[] findMode(int[] scores) {
	   Arrays.sort(scores);
	   int maxOccurrence = 1; // store the occurrence of the mode
	   int occurrence = 1; // store the occurrence of each score
	   for(int i = 0; i < scores.length-1; i++){
		   if(scores[i+1] == scores[i]){
			   occurrence++;
			   if(occurrence > maxOccurrence){
				   maxOccurrence = occurrence;
			   }
		   }
		   else {
			   occurrence = 1;
		   }
	   }
	   ArrayList<Integer> list = new ArrayList<Integer>();
	   for(int i = 0; i < scores.length; i++){
		   if(counts(scores[i], scores) == maxOccurrence && !list.contains(scores[i])){
			   list.add(scores[i]);
		   }
	   }
	   // make the ArrayList list into an array mode
	   int[] mode = new int[list.size()];
	   for(int i = 0; i < list.size(); i++){
		   mode[i] = list.get(i);
	   }
	   return mode;
   }
	/**
	 * @param score score to be counted
	 * @param scores score list 
	 * @return occurrence of the score
	 */
   public int counts(int score, int[] scores){
	   int counter = 0;
	   for(int i = 0; i < scores.length; i++){
		   if(scores[i] == score){
			   counter++;
		   }
	   }
	   return counter;
   }
}
