import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class TestGenerate {
	
	private String letterAnswer;
	private String wordAnswer;
	
	@Before
	public void setUp() {
		try {
			Scanner scan = new Scanner(new File("data/expectedLetter.txt"));
			while (scan.hasNextLine()) {
				letterAnswer = scan.nextLine();
			}
			scan.close();
			scan = new Scanner(new File("data/expectedWord.txt"));
			wordAnswer = scan.useDelimiter("\\Z").next();
			scan.close();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testBrute() {
		try {
			BruteGenerator btg = new BruteGenerator(54321);
			BufferedInputStream alice = new BufferedInputStream(new FileInputStream("data/alice.txt"));
			alice.mark(Integer.MAX_VALUE);
			btg.train(new Scanner(alice),"",3);
			String[] parts = btg.generateText(500).split("\n");
			assertEquals(letterAnswer, parts[parts.length - 1]);
			
			alice.reset();
			btg.train(new Scanner(alice), "\\s+", 3);
			assertEquals(wordAnswer, btg.generateText(100));
		}
		catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}
	

	@Test
	public void testMap() {
		try {
			MapGenerator mtg = new MapGenerator(54321);
			BufferedInputStream alice = new BufferedInputStream(new FileInputStream("data/alice.txt"));
			alice.mark(Integer.MAX_VALUE);
			mtg.train(new Scanner(alice),"",3);
			String[] parts = mtg.generateText(500).split("\n");
			assertEquals(letterAnswer, parts[parts.length - 1]);
			
			alice.reset();
			mtg.train(new Scanner(alice), "\\s+", 3);
			assertEquals(wordAnswer, mtg.generateText(100));
		}
		catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch (IOException io) {
			io.printStackTrace();
		}
	}
}