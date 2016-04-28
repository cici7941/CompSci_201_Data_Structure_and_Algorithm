import java.util.*;
public class SpreadingNews {
	public int minTime(int[] bosses) {
		return minBoss(0, bosses);
	}
	public int minBoss(int boss, int[] bosses) {
		
		ArrayList<Integer> subs = new ArrayList<Integer>();
		for(int i = 0; i < bosses.length; i++){
			if(bosses[i] == boss){
				subs.add(minBoss(i, bosses));
			}
		}
		if(subs.size() == 0) return 0;
		Collections.sort(subs, Collections.reverseOrder());
	
		int max = subs.get(0)+1;
	
		for(int child = 1; child < subs.size(); child++){
			if(subs.get(child)+child+1>max){
				max = subs.get(child)+child+1;
			}
		}
		return max;
	}
}
