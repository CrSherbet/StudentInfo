package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Abstract class of class BufferedReaderTask. It creates new BufferedReader and InputStreamReader to read a word list.
 * @author Warisara Inprom
 *
 */
abstract class BufferedReaderTask implements Runnable {
	protected BufferedReader br = null;
	/**
	 * Constructor of this class.
	 */
	public BufferedReaderTask() {
		try {
			br = new BufferedReader(new InputStreamReader(Dictionary.getWordsAsStream()));
		} catch (Exception ex) {
			out.println("Could not open dictionary: " + ex.getMessage());
			return;
		}
	}
}
