
public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r, 
            int x1, int y1, int x2, int y2) {
    	// begin help from TA Jaret Karnuta in recitation
    	// Jaret taught me how to write a helper method and give appropriate comments
    	int borderCrossed = 0; //borderCrossed++ when one point is inside the circle while the other is not
    	for(int i = 0; i < x.length; i++)
    	{
    		if(pointInCircle(x[i], y[i], r[i], x1, y1) != pointInCircle(x[i], y[i], r[i], x2, y2))
    		{
    			borderCrossed++;
    		}
    	}

    return borderCrossed;
    }    	
	/**
	 * @param locx x coord of center of circle
	 * @param locy y coord of center of circle
	 * @param r radius of circle
	 * @param pointx x coord of point 
	 * @param pointy y coord of point 
	 * @return if point is in circle
	 */
    private boolean pointInCircle(int locx, int locy, int r, int pointx, int pointy){
	double dx = locx - pointx;
	double dy = locy - pointy;
	double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	return distance < r;
	}
    // end help from TA Jaret Karnuta in recitation
}
