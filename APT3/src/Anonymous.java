import java.util.HashMap;

public class Anonymous {
	private HashMap<Character,Integer> avail;	
	private HashMap<Character,Integer> need;
	
	public Anonymous(){
		avail = new HashMap<Character,Integer>();
		need = new HashMap<Character,Integer>();
	}
	
	public int howMany(String[] headlines, String[] messages) {
		int total = 0;
		initializeAvail(headlines, avail);
		for(String message : messages){
			initializeNeed(message, need);
			if (canWrite(avail, need)) total++;
		}
        return total;
	}


private void initializeAvail(String[] headlines,
			HashMap<Character, Integer> avail2) {
		avail2.clear();
		
		int count = 0;
		for(String headline : headlines){
			for (char letter = 0; letter < headline.length(); letter++) {
				char currentChar = Character.toUpperCase(headline.charAt(letter));
				
				if (Character.isUpperCase(currentChar)) {
					Character current = (Character) currentChar;
					if (avail2.containsKey(current)) {
						count = avail2.get(currentChar);
						count++;
					} else {
					count = 1;
					}
				avail2.put(currentChar, (Integer) count);
				}
			}
		}
	}

private void initializeNeed(String message, HashMap<Character,Integer> need) {
	need.clear();
	int count = 0;
	
	for (char letter = 0; letter < message.length(); letter++) {
		char currentChar = Character.toUpperCase(message.charAt(letter));
		
		if (Character.isUpperCase(currentChar)) {
			Character current = (Character) currentChar;
			if (need.containsKey(current)) {
				count = need.get(currentChar);
				count++;
			} else {
				count = 1;
			}
			need.put(currentChar, (Integer) count);
		}
	}
}


private boolean canWrite(HashMap<Character,Integer> avail, HashMap<Character,Integer> need) {
		for (Character key : need.keySet() ) {
	    	if (avail.containsKey(key)) {
	    		if (need.get(key) > avail.get(key)) return false;
	    	} else {
	    		return false;
	    	}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymous test = new Anonymous();
		String[] headlines1 = {"Earthquake in San Francisco", "Burglary at musuem in Sweden", "Poverty"};
		String[] messages1 = {"Give me my money back", "I am the best coder", "TOPCODER"};
		System.out.println(test.howMany(headlines1,messages1));
		
		String[] headlines2 = {"Programming is fun"};
		String[] messages2 = {"program","programmer","gaming","sing","NO FUN"};
		System.out.println(test.howMany(headlines2,messages2));

	}

}