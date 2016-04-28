import java.util.ArrayList;
public class GridGame {
    private char[][] myGrid; // 2D grid data structure
    private static final int MYSIZE = 4; // 4x4 Grid
    // always use final for constants
 
    /**
     * Allocates memory for myGrid
     * Constructor should initialize all instances
     */
    GridGame() { 
        myGrid = new char[MYSIZE][MYSIZE]; 
    }
    
    public int winningMoves(String[] grid){
        // Set up the grid
    	initializeGrid(grid);
    	// printGrid();
    	return countWins();
    }
    
    /**
     * Sets myGrid[r][c] to be grid[row].charAt(col)
     * @param grid is the input position from the APT method
     */
    public void initializeGrid(String[] grid) {
        int row = 0;
        for (String s : grid) { // iterator
            for (int col = 0; col < MYSIZE; col++){
                myGrid[row][col] = s.charAt(col); 
            }
            row++;
        }
    }
    
    /**
     * Print myGrid for debugging/instructional purposes
     */
    private void printGrid() {
        for (int row = 0; row < MYSIZE; row++) {
            for (int col = 0; col < MYSIZE; col++){
                System.out.print(myGrid[row][col]); 
            }
            System.out.println(); // Next line  
        }
        System.out.println("----"); // Next line  
	}

    /**
     * Find legal moves on global myGrid and return a list of these
     * moves where each move is int[] with [0] = row and [1] = col
     * @return list of all open/legal moves in gridgame
     */
    private ArrayList<int[]> nextMoves(){
        ArrayList<int[]> list = new ArrayList<int[]>();
        for(int r=0; r < MYSIZE; r++){
            for(int c=0; c < MYSIZE; c++){
                if (myGrid[r][c] == '.' && neighborsClear(r,c)){
                    int[] t = new int[2];
                    t[0] = r; 
                    t[1] = c;
                    list.add(t);
                }
            }
        }
        return list;
    }
    
    /**
     * Return true if and only if myGrid[r][c] is a '.', i.e.,
     * returns false if not on board or an 'X'
     * @param r is row being checked
     * @param c is col being checked
     * @return true iff myGrid[r][c] == '.'
     */
    private boolean isDot(int r, int c){
        if (r >= 0 && r < MYSIZE && c >= 0 && c < MYSIZE){
            return myGrid[r][c] == '.';
        }
        return true;
    }
    
    /**
     * return true if and only if myGrid[r][c] is open for a move, i.e.,
     * myGrid[r][c] is not adjacent to an 'X'
     * @param r is row being checked
     * @param c is col being checked
     * @return true iff myGrid[r][c] can hold an 'X', i.e., is not adjacent to an 'X'
     */
    
    private boolean neighborsClear(int r, int c) {
        return 
            isDot(r+1,c) && isDot(r-1,c) &&
            isDot(r,c+1) && isDot(r,c-1);
    }
    
    /**
     * Return the number of wins possible from this position
     * Looks at myGrid to get the position
     * Uses recursive backtracking by trying each move and backtracking as needed
     * Calls nextMove() to get the list of legal moves
     * @return the numbers of wins possible for the current position
     */
    public int countWins(){
    	int wins = 0;
    	ArrayList<int[]> moves = nextMoves(); // method to compute wins 
    	
    	for  (int[] m: moves) {
    		int r = m[0];
    		int c = m[1];
    		myGrid[r][c] = 'X';
    		if (countWins() == 0) {
    			wins++;
    		}
    		myGrid[r][c] = '.';
    	}
    	return wins;
    }
    
    
    public static void main(String[] args){
        String[] s1 = {"....",
                		"....",
                		".X..",
                		"...."
        };
        GridGame game1 = new GridGame();
        int wins1 = game1.winningMoves(s1);
        System.out.println("wins =" + wins1);
        System.out.println("===="); // Next line  
        String[] s2 = {"....",
        		 		"....",
        		 		"....",
        		 		"...."};
        GridGame game2 = new GridGame();
        int wins2 = game2.winningMoves(s2);
        System.out.println("wins =" + wins2);
        System.out.println("===="); // Next line  
        String[] s3 = {"..X.",
		 		"X...",
		 		"..X.",
		 		"...X"};
GridGame game3 = new GridGame();
int wins3 = game3.winningMoves(s3);
System.out.println("wins =" + wins3);
System.out.println("===="); // Next line  
    }
}