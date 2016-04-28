import java.util.Arrays;
import java.util.List;

public class NGram implements Comparable<NGram> {

	private String[] contents;
	private String separator;
	
	public NGram(List<String> source, String sep) {
		separator = sep;
		contents = new String[source.size()];
		contents = Arrays.copyOf(source.toArray(new String[source.size()]), source.size());
	}

	public int compareTo(NGram other) {
		// TODO: complete compareTo per the specifications defined by Comparable and the assignment.
		return 0;
	}

	public boolean equals(Object o) {
		// TODO: complete equals per the specifications defined by the Object class and the assignment.
		return false;
	}

	public int hashCode() {
		// TODO: define a hashCode function which minimizes the number of collisions of NGrams in a HashMap or Set.
		return 0;
	}

	public String toString() {
		// TODO: create a String representation of an NGram based on the assignment specification.
		return "";
	}
}