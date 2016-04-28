import java.util.PriorityQueue;

public class HuffProcessor implements Processor{

	@Override
	public void compress(BitInputStream in, BitOutputStream out) {
		//count characters in file
		int[] count = new int[ALPH_SIZE];
		while(true){
			int character = in.readBits(BITS_PER_WORD);
			if(character == -1)
				break;
			count[character]++;
		}
		in.reset();
		//create Huffman tree
		PriorityQueue<HuffNode> HuffmanTree = new PriorityQueue<HuffNode>();
		for(int i = 0; i < ALPH_SIZE; i++){
			if(count[i] != 0){
				HuffmanTree.add(new HuffNode(i, count[i]));
			}
		}
		HuffmanTree.add(new HuffNode(PSEUDO_EOF, 0));
		while(HuffmanTree.size() > 1){
			HuffNode sub1 = HuffmanTree.poll();
			HuffNode sub2 = HuffmanTree.poll();
			HuffmanTree.add(new HuffNode(-1, sub1.weight()+sub2.weight(), sub1, sub2));
		}
		//traverse tree and extract codes
		String[] codes = new String[ALPH_SIZE+1];
		HuffNode root = HuffmanTree.poll();
		extractCodes(root, "", codes);
		//write the header
		out.writeBits(BITS_PER_INT, HUFF_NUMBER);
		writeHeader(root, out);
		//compress
		while(true){
			int character = in.readBits(BITS_PER_WORD);
			if(character == -1)
				break;
			String code = codes[character];
			out.writeBits(code.length(), Integer.parseInt(code, 2));
		}
		//write the pseudo-EOF
		String code = codes[PSEUDO_EOF];
		out.writeBits(code.length(), Integer.parseInt(code, 2));
	}

	private void extractCodes(HuffNode current, String path, String[] codes) {
		if(current.left() == null && current.right() == null){
			codes[current.value()] = path;
			return;
		}
		extractCodes(current.left(), path + 0, codes);
		extractCodes(current.right(), path + 1, codes);
	}
	
	private void writeHeader(HuffNode current, BitOutputStream out){
		if(current.left() == null && current.right() == null){
			out.writeBits(1, 1);
			out.writeBits(BITS_PER_WORD + 1, current.value());
			return;
		}
		out.writeBits(1, 0);
		writeHeader(current.left(), out);
		writeHeader(current.right(), out);
	}
	
	@Override
	public void decompress(BitInputStream in, BitOutputStream out) {
		//check for HUFF_NUMBER
		if(in.readBits(BITS_PER_INT) != HUFF_NUMBER)
			throw new HuffException("HUFF_NUMBER is not presented!");
		//recreate the Hufftree from header
		HuffNode root = readHeader(in);
		// parse body of compressed file
		HuffNode current = root;
		while(true){
			int bit = in.readBits(1);
			if(bit == -1)
				break;
			if(bit == 1)
				current = current.right();
			else 
				current = current.left();
			if(current.left() == null && current.right() == null){
				if(current.value() == PSEUDO_EOF)
					return;
				else { 
					out.writeBits(BITS_PER_WORD, current.value());
				    current = root;
				    }
			}
		}	
	}
	private HuffNode readHeader(BitInputStream in){
		if(in.readBits(1) == 0){
			HuffNode left = readHeader(in);
			HuffNode right = readHeader(in);
			return new HuffNode(-1, 0, left, right);
		} else {
			return new HuffNode(in.readBits(BITS_PER_WORD+1), 0);
		}
	}
}
