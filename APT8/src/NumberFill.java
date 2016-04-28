import java.util.Stack;

public class NumberFill {
	  private char[][] grid;
	  private Stack<Integer> numbers;
	  private int maxNum, maxCol;
	  private int numRow, numCol;
	  private boolean hasColor;
	  private int score;
      public int gradient(String[] picture) {
    	 numRow = picture.length;
    	 numCol = picture[0].length();
    	 score = 0;
    	 grid = new char[numRow][numCol];
    	 numbers = new Stack<Integer>();
         for(int i = 0; i < numRow; i++)
        	 for(int j = 0; j < numCol; j++)
        		 grid[i][j] = picture[i].charAt(j);
      // loop over the array to sum numbers
		  for(int i = 0; i < numRow; i++){
	   		  for(int j = 0; j < numCol; j++){
	   			  maxNum = 0;
	   			  maxCol = numCol;
	   			  hasColor = false;
	   			  if(!numbers.isEmpty())
	   				  numbers.clear();
   				  search(i, j);
   				  if(hasColor){
	   				  while(!numbers.isEmpty())
	   					  score += numbers.pop() - maxCol + maxNum;
   				  }
	   		  }
	   	  }
		  return score;
      }
      
      private void search(int row, int col){
    	  if(row < 0 || row >= numRow || col < 0 || col >= numCol)
    		  return;
    	  if(grid[row][col] == 'X')
    		  return;
    	  else if(grid[row][col] == '.'){
    		  grid[row][col] = 'X';
    		  numbers.push(col);
    		  search(row-1, col);
        	  search(row+1, col);
        	  search(row, col-1);
        	  search(row, col+1);
    	  } else {
    		  hasColor = true;
    		  int num = Character.getNumericValue(grid[row][col]);
    		  if(num > maxNum || (num == maxNum && col < maxCol)){
    			  maxCol = col;
    			  maxNum = num;
    		  }
    		  numbers.push(col);
    		  grid[row][col] = 'X';
    		  search(row-1, col);
        	  search(row+1, col);
        	  search(row, col-1);
        	  search(row, col+1);
    	  }
      }
   }