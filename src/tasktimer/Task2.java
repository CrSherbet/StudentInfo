package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the readLine() method.  readLine() returns null when there is no more input.
 * Display summary statistics and elapsed time.
 * 
 * @author Warisara Inprom
 * 
 */
public class Task2 extends BufferedReaderTask {
	/**
	 * Attributes of class Task2.
	 */
	BufferedReader br ;
	InputStream instream ;
	
	/**
	 * Constructors of class Task2.
	 */
	public Task2(){
		super();
		instream = Dictionary.getWordsAsStream();
        br = null;
	}

	/**
	 * Run class Task2.
	 */
	@Override
	public void run() {
        try {
            int count = 0;
            long totalsize = 0;
            String word = null;
            while( (word=br.readLine()) != null ) {
                totalsize += word.length();
                count++;
            }
            double averageLength = ((double)totalsize)/(count>0 ? count : 1);
            out.printf("Average length of %,d words is %.2f\n", count, averageLength);  
        } catch(IOException ioe) {
            out.println(ioe);
            return;
        } finally {
            try { br.close(); } catch (Exception ex) { /* ignore it */ }
        }	
	}
	
	/**
	 * Return description of task.
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader.readLine() with a loop" ;
	}

}
