
public class CountAppearances {
    public int numberTimesAppear(int number, int digit) {
    	int numberAppearances = 0; // 1233 2 numberOccerrence=2
        while(true){
        	if(number % 10 == digit) // check if digit occurs in units digit
        	{
        		numberAppearances++;
        	}
        	number /= 10; // remove units digit
        	if(number == 0) // break out of loop when all digits have been checked
        	{
        		break;
        	}
        }
        return numberAppearances;
    }
  }