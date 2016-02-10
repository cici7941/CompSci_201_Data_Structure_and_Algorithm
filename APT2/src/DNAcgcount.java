
public class DNAcgcount
{
    public double ratio(String dna)
    {
            double cgCount = 0; // count c and g in a strand of DNA
            double ratio = 0; // the ratio of c and g in all nucleotides
            if(dna.length() > 0)
            {
            	for(int k=0; k<dna.length(); k++)
            	{
            		if(dna.charAt(k) == 'c' || dna.charAt(k) == 'g')
            		{
            			cgCount++;
            		}
            	}
            	ratio = cgCount/dna.length();
            }
            return ratio;
    }
}