public class BoggleScore {
      public long bestScore(String[] grid, 
                            String[] words){
    	 long score = 0;
         long[][] largeGrid = new long[6][6];
         for(String word : words){
        	 initialize(largeGrid);
        	 char letter0 = word.charAt(0);
    		 for(int j=0; j<grid.length; j++){
    			 for(int k=0; k<grid[0].length(); k++){
    				 if(grid[j].charAt(k)==letter0){
    					 largeGrid[j+1][k+1] = 1;
    				 }
    			 }
    		 }
    		 long[][] copy = copy2dArray(largeGrid);
        	 for(int i=1; i<word.length(); i++){
        		 initialize(largeGrid);
        		 char letter = word.charAt(i);
        		 for(int j=0; j<grid.length; j++){
        			 for(int k=0; k<grid[j].length(); k++){
        				 if(grid[j].charAt(k)==letter){
        					 largeGrid[j+1][k+1] = sumAround(copy,j+1,k+1);
        				 }
        			 }
        		 }
        		 copy = copy2dArray(largeGrid);
        	 }
        	 long way = (long) (sumWays(largeGrid)%1E13);
        	 score += (((way*word.length())%1E13)*word.length())%1E13;
         }
         return (long) (score%1E13);
      }
      private void initialize(long[][] grid){
    	  for(int i = 0; i<grid.length; i++){
    		  for(int j = 0; j<grid.length; j++){
    			  grid[i][j]=0;
    		  }
    	  }
      }
      private long sumAround(long[][] array, int row, int col){
    	  long sum = 0;
    	  for(int i = row-1; i<=row+1; i++){
    		  for(int j = col-1; j<=col+1; j++){
    			  sum+=array[i][j];
    		  }
    	  }
    	  return (long) ((sum-array[row][col])%1E13);
      }
      private long sumWays(long[][] array){
    	  long sum = 0;
    	  for(int i = 0; i<array.length; i++){
    		  for(int j = 0; j<array.length; j++){
    			  sum+=array[i][j];
    		  }
    	  }
    	  return (long) (sum%1E13);
      }
      private long[][] copy2dArray(long[][] array){
    	  int len = array.length;
    	  long[][] copy = new long[len][len];
    	  for(int i=0; i<len; i++){
    		  for(int j=0; j<len; j++){
    			  copy[i][j]=array[i][j];
    		  }
    	  }
    	  return copy;
      }
  }