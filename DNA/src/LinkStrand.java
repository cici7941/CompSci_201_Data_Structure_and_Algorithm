import java.util.Iterator;
import java.util.Stack;


public class LinkStrand implements IDnaStrand, Iterator<String> {
	private Node myHead; //The first node in the linked list
	private Node myTail; //The last node in the linked list
	private Node current; //The current node in the linked list
	private long size; //The size of the LinkStrand
	private int numAppends; //the times of appending
	/**
	 * The inner Node class used in implementing the Linked List
	 */
	public class Node{
		private String value; //The string value contained by this node
		private Node next; //A pointer to the next node in the linked list
		
		public Node(){
			value = null;
			next = null;
		}
		
		public Node(String s){
			value = s;
			next = null;
		}
		
		public Node(String s, Node n){
			value = s;
			next = n;
		}
	}
	/**
	 * Create a strand representing an empty DNA strand, length of zero.
	 */
	public LinkStrand() {
		this("");
	}

	/**
	 * Create a strand representing s. No error checking is done to see if s
	 * represents valid genomic/DNA data.
	 * 
	 * @param s
	 *            is the source of cgat data for this strand
	 */
	public LinkStrand(String s) {
		initialize(s);
	}
	
	/**
	 * Initialize this strand so that it represents the value of source. No
	 * error checking is performed.
	 * 
	 * @param source
	 *            is the source of this enzyme
	 */
	@Override
	public void initialize(String source) {
		myHead = new Node(source);
		myTail = myHead;
		current = myHead;
		numAppends = 0;
		size = source.length();
	}

	/**
	 * Cut this strand at every occurrence of enzyme, essentially replacing
	 * every occurrence of enzyme with splicee.
	 * 
	 * @param enzyme
	 *            is the pattern/strand searched for and replaced
	 * @param splicee
	 *            is the pattern/strand replacing each occurrence of enzyme
	 * @return the new strand leaving the original strand unchanged.
	 */
	@Override
	public IDnaStrand cutAndSplice(String enzyme, String splicee) {
		int pos = 0;
		int start = 0;
		String search = myHead.value;
		boolean first = true;
		LinkStrand ret = null;

		/*
		 * The next line is very syntax-dense. .indexOf looks for the first
		 * index at which enzyme occurs, starting at pos. Saying pos = ...
		 * assigns the result of that operation to the pos variable; the value
		 * of pos is then compared against zero.
		 * 
		 * .indexOf returns -1 if enzyme can't be found. Therefore, this line
		 * is:
		 * 
		 * "While I can find enzyme, assign the location where it occurs to pos,
		 * and then execute the body of the loop."
		 */
		while ((pos = search.indexOf(enzyme, pos)) >= 0) {
			if (first) {
				ret = new LinkStrand(search.substring(start, pos));
				first = false;
			} else {
				ret.append(search.substring(start, pos));

			}
			start = pos + enzyme.length();
			ret.append(splicee);
			pos++;
		}

		if (start < search.length()) {
			// NOTE: This is an important special case! If the enzyme
			// is never found, return an empty String.
			if (ret == null) {
				ret = new LinkStrand("");
			} else {
				ret.append(search.substring(start));
			}
		}
		return ret;
	}

	/**
	 * Returns the number of nucleotides/base-pairs in this strand.
	 */
	@Override
	public long size() {
		return size;
	}
	
	/**
	 * Return some string identifying this class.
	 * 
	 * @return a string representing this strand and its characteristics
	 */
	@Override
	public String strandInfo() {
		return this.getClass().getName();
	}

	/**
	 * Returns a string that can be printed to reveal information about what
	 * this object has encountered as it is manipulated by append and
	 * cutAndSplice.
	 * 
	 * @return
	 */
	@Override
	public String getStats() {
		return String.format("# append calls = %d", numAppends);
	}

	/**
	 * Returns the sequence of DNA this object represents as a String
	 * 
	 * @return the sequence of DNA this represents
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		Node current = myHead;
		while (current != null){
			output.append(current.value);
			current = current.next;
		}
		return output.toString();
	}

	/**
	 * Append a strand of DNA to this strand. If the strand being appended is
	 * represented by a LinkStrand object then an efficient append is performed.
	 * 
	 * @param dna
	 *            is the strand being appended
	 */
	@Override
	public void append(IDnaStrand dna) {
		if(dna.strandInfo() == "LinkStrand"){
			LinkStrand dnaLink = (LinkStrand) dna;
			myTail.next = dnaLink.myHead;
			myTail = myTail.next;
			numAppends++;
			size += dnaLink.size;
		} else {
			Node add = new Node(dna.toString());
			myTail.next = add;
			myTail = myTail.next;
			numAppends++;
			size += add.value.length();
		}
	}

	/**
	 * Simply append a strand of dna data to this strand.
	 * 
	 * @param dna
	 *            is the String appended to this strand
	 */
	@Override
	public void append(String dna) {
		Node add = new Node(dna);
		myTail.next = add;
		myTail = myTail.next;
		numAppends++;
		size += dna.length();
	}

	/**
	 * Returns an IDnaStrand that is the reverse of this strand, e.g., for
	 * "CGAT" returns "TAGC"
	 * 
	 * @return reverse strand
	 */
	@Override
	public IDnaStrand reverse() {
		Stack<Node> stack = new Stack<Node>();
		Node current = this.myHead;
		while(current!= null){
			String reverseString = new StringBuilder(current.value).reverse().toString();
			Node push = new Node(reverseString);
			stack.push(push);
			current = current.next;
		}
		LinkStrand reverse = new LinkStrand();
		while(!stack.empty()){
			reverse.append(stack.pop().value);
		}
		return reverse;
	}
	
	/**
	 *	Returns the next element in the underlying LinkedList data structure
	 */
	@Override
	public String next() {
		Node next = current;
		current = current.next;
		return next.value;
	}
	
	/**
	 *	True if next evaluates correctly
	 *	False if next returns with an error
	 */
	@Override
	public boolean hasNext() {
		if(current == null)
			return false;
		return true;
	}
}

