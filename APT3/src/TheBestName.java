import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
	public String[] sort(String[] names) {

		class LengthAlpha implements Comparator<String> {
	
			public int compare(String o1, String o2) {
				if(o1.equals("JOHN")){
					return -1;
				}
				if(o2.equals("JOHN")){
					return 1;
				}
				if (weight(o1) != weight(o2)) {
					return weight(o2) - weight(o1);
				} else {
					return o1.compareTo(o2);
				}
			}	
		}	
	Arrays.sort(names, new LengthAlpha());
	return names;
}
	public int weight(String o){
		int weight1 = 0;
		for(int i = 0; i <o.length(); i++){
			weight1 += o.charAt(i) - 64;
		}
	return weight1;
	}
}
