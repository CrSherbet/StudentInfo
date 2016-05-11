package tasktimer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/** 
 * Append all the words from the dictionary to a String.
 * This shows why you should be careful about using "string1"+"string2".
 * @author Warisara Inprom
 */
public class Task5 implements Runnable {
	/**
	 * Attributes of class Task5.
	 */
	static final int MAXCOUNT = 50_000;
	InputStream instream;
	BufferedReader br;

	/**
	 * Constructor of class Task5.
	 */
	public Task5() {
		instream = Dictionary.getWordsAsStream();
		br = null;
	}

	/**
	 * Run class Task5.
	 */
	@Override
	public void run() {
		String result = "";
		String word = null;
		int count = 0;
		try {
			while ((word = br.readLine()) != null && count < MAXCOUNT) {
				result = result + word;
				count++;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.printf("Done appending %d words to string.\n", count);

	}

	/**
	 * Return description of task.
	 */
	public String toString() {
		return "Starting task: append " + MAXCOUNT + " words to a String using +";
	}

}
