public class RatRoute {
  public int numRoutes(String[] enc) {
	  int ratRow=0;
	  int ratCol=0; 
	  int cheeseRow=0;
	  int cheeseCol=0;
	  for(int i=0; i<enc.length; i++){
		  for(int j=0; j<enc[i].length(); j++){
			  if(enc[i].charAt(j) == 'R'){
				ratRow = i;
				ratCol = j;
			  }
			  if(enc[i].charAt(j) == 'C'){
				cheeseRow = i;
				cheeseCol = j;
			  }
		  }
	  }
   	  return numRoutes(enc, ratRow, ratCol, cheeseRow, cheeseCol);
  }
  
  private int numRoutes(String[] enc, int row, int col, int cheeseRow, int cheeseCol){
	  if(row == cheeseRow && col == cheeseCol){
		  return 1;
	  } else if(enc[row].charAt(col) == 'X'){
		  return 0;
	  } else if(row == cheeseRow && col != cheeseCol){
		  return numRoutes(enc, row, col+(int)Math.signum(cheeseCol-col), cheeseRow, cheeseCol);
	  } else if(row != cheeseRow && col == cheeseCol){
		  return numRoutes(enc, row+(int)Math.signum(cheeseRow-row), col, cheeseRow, cheeseCol);
	  } else {
		  return numRoutes(enc, row+(int)Math.signum(cheeseRow-row), col, cheeseRow, cheeseCol)+numRoutes(enc, row, col+(int)Math.signum(cheeseCol-col), cheeseRow, cheeseCol);
	  }
  }
}

