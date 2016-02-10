import java.util.*;

public class SandwichBar
   {
      public int whichOrder(String[] available, String[] orders){
    	 //begin help from http://stackoverflow.com/questions/7347856/how-to-convert-a-string-into-an-arraylist
    	 //I didn't know how to convert a string into an ArrayList
    	 List<String> avail = new ArrayList<String>(Arrays.asList(available));
    	 //end help from http://stackoverflow.com/questions/7347856/how-to-convert-a-string-into-an-arraylist
         for(int i = 0; i < orders.length; i++)
         {
        	 //begin help from http://javadevnotes.com/java-string-split-tutorial-and-examples
        	 //I didn't know how to split a string
        	 String[] ingredients = orders[i].split(" ");
        	 //end help from http://javadevnotes.com/java-string-split-tutorial-and-examples
        	 boolean include = true; // the restaurant has the ingredients I desire
        	 for(int j = 0; j < ingredients.length; j++)
        	 {
        		 include = avail.contains(ingredients[j]) && include;
        	 }
        	 if(include)
        	 {
        	 return i;
        	 }
         }
         return -1;
      }
   }