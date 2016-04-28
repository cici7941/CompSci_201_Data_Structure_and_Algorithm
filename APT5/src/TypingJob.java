import java.util.*;

public class TypingJob {
	List<Integer> times;
	public TypingJob(){
		times = new ArrayList<Integer>();
	}
    public int bestTime(int[] pages) {
    	assign(0, 0, 0, 0, pages);
    	Collections.sort(times);
    	return times.get(0);
    }
    private void assign(int count, int assist1, int assist2, int assist3, int[] pages){
    	if(count == pages.length){
    		int max = assist1;
    		if(assist2 > max) max = assist2;
    		if(assist3 > max) max = assist3;
    		times.add(max);
    		return;
    	}
	assign(count+1, assist1 + pages[count], assist2, assist3, pages);
	assign(count+1, assist1, assist2 + pages[count], assist3, pages);
	assign(count+1, assist1, assist2, assist3 + pages[count], pages);
    }
}