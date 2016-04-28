import java.util.HashMap;

public class HuffmanDecoding {
      public String decode(String archive, String[] dictionary) {
    	  	StringBuilder decode = new StringBuilder();
            HashMap<String, String> dict = new HashMap<String, String>();
            for(int i=0; i<dictionary.length; i++){
            	char alphabet = (char) ('A'+i);
            	dict.put(dictionary[i], alphabet+"");
            }
            int sp=0;
            int i=1;
            while( sp+i<= archive.length()){
            	String code = archive.substring(sp, sp+i);
            	if(dict.containsKey(code)){
            		decode.append(dict.get(code));
            		sp = sp+i;
            		i=1;
            	}
            	else i++;
            }
            return decode.toString();
      }
   }
