package tasktimer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Append all the words from the dictionary to a StringBuilder. Compare how long
 * this takes to appending to String.
 */
public class Task6 extends BufferedReaderTask {
	/**
	 * Attributes of class Task6.
	 */
	static final int MAXCOUNT = 50_000;
	InputStream instream;
	BufferedReader br;

	/**
	 * Constructor of class Task6.
	 */
	public Task6() {
		instream = Dictionary.getWordsAsStream();
		br = null;
	}

	/**
	 * Run class Task6.
	 */
	@Override
	public void run() {
		StringBuilder result = new StringBuilder();
		String word = null;
		int count = 0;
		try {
			while ((word = br.readLine()) != null && count < MAXCOUNT) {
				result.append(word);
				count++;
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.printf("Done appending %d words to StringBuilder.\n", count);
	}

	/**
	 * Return description of task.
	 */
	public String toString() {
		return "Starting task: append " + MAXCOUNT + " words to a StringBuilder";
	}

}
