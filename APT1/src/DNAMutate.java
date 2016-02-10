public class DNAMutate {
      public String mutate(String dna) {
    	  String reverse = ""; // dna = abc, reverse = cba
    	  for(int k=0; k<dna.length(); k++)
    	  {
    		  reverse = dna.charAt(k) + reverse;
    	  }
		return reverse;
      }
}
