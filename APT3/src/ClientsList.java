import java.util.*;

public class ClientsList {
       public String[] dataCleanup(String[] names) {
    	   // format the names
    	   Arrays.asList(names);
    	   for(int i = 0; i < names.length; i++){
    		   if(names[i].contains(",")){
    			   String[] lastFirst = names[i].split(", ");
    			   names[i] = lastFirst[1] + " " + lastFirst[0];
    		   }
    	   }
    	   // sort the clients
    	   for(int i = names.length - 1; i > 0; i--){
    		   for(int j = 0; j < i; j++){
    			   if(nameExchange(names[j], names[j+1])){
    				   String temp = names[j];
    				   names[j] = names[j+1];
    				   names[j+1] = temp;
    			   }
    		   }
    	   }
    	   return names;
       }
       // helper method check if names order should be exchanged
       public boolean nameExchange(String name1, String name2){
    	   String[] firstLast1 = name1.split(" ");
    	   String[] firstLast2 = name2.split(" ");
    	   if(firstLast1[1].compareTo(firstLast2[1]) > 0){
    		   return true;
    	   } else if(firstLast1[1].compareTo(firstLast2[1]) == 0 &&
    			   firstLast1[0].compareTo(firstLast2[0]) > 0){
    		   return true;
    	   } else{
    		   return false;
    	   }
       }
   }