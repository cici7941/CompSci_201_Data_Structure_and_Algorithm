public class FloodRelief {
	  // count the number of visited squares
	  Integer numVisited = 0;
	  // count the number of pumps
	  int pumps = 0;
      public int minimumPumps(String[] heights){
         // create a grid to store visited squares
    	  int col = heights[0].length();
    	  int row = heights.length;
    	  int[][] visited = new int[row][col];
    	  // loop over the array to count pumps
    	  outerloop:
    	  for(char letter = 'a'; letter <= 'z'; letter++){
    		  for(int i = 0; i < row; i++){
        		  for(int j = 0; j < col; j++){
        			  if(heights[i].charAt(j) == letter && visited[i][j] == 0){
        				  if(numVisited >= row*col)
        					  break outerloop;
        				  pumps += 1;
        				  pump(i, j, heights, visited, row, col);
        			  }
        		  }
        	  }
    	  }
    	  return pumps;
      }
      /**
       * update visited array and numVisited counter
       * @param i is row index of square
       * @param j is column index of square
       * @param heights is rectangular grid representing the height of each square
       * @param visited is grid to store visited squares
       * @param row is the number of rows of heights
       * @param col is the number of columns of heights
       */
      private void pump(int i, int j, String[] heights, int[][] visited, int row, int col){
    	  if(numVisited > row * col || visited[i][j] == 1){
    		  return;
    	  }
    	  visited[i][j] = 1;
    	  numVisited += 1;
    	  if(j-1 >= 0 && heights[i].charAt(j-1) >= heights[i].charAt(j))
    	  pump(i, j-1, heights, visited, row, col);
    	  if(j+1 < col && heights[i].charAt(j+1) >= heights[i].charAt(j))
    	  pump(i, j+1, heights, visited, row, col);
    	  if(i-1 >= 0 && heights[i-1].charAt(j) >= heights[i].charAt(j))
    	  pump(i-1, j, heights, visited, row, col);
    	  if(i+1 < row && heights[i+1].charAt(j) >= heights[i].charAt(j))
    	  pump(i+1, j, heights, visited, row, col);
      }
  }