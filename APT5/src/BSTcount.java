  public class BSTcount {
      public long howMany(int[] values) {
            return howMany(values.length);
      }
      
      private long howMany(int size) {
    	  long[] tree = new long[size+1];
    	  tree[0] = 1;
    	  for(int j=1; j<=size; j++){
    		  long count = 0;
	    	  for(int leftSize=0; leftSize < j; leftSize++){
	    		  int rightSize = j-leftSize-1;
	    		  count += tree[leftSize]*tree[rightSize];
	    	  }
	    	  tree[j]=count;
    	  }
    	  return tree[size];
      }
   }