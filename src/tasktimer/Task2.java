package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the readLine() method.  readLine() returns null when there is no more input.
 * Display summary statistics and elapsed time.
 */
public class Task2 implements Runnable {
	/**
	 * Attribute of class Task2
	 */
	BufferedReader br ;
	InputStream instream ;
	
	/**
	 * Constructor of class Task2
	 */
	public Task2(){
		instream = Dictionary.getWordsAsStream();
        br = null;
	}

	/**
	 * Run class Task2
	 */
	@Override
	public void run() {
        try {
            br = new BufferedReader( new InputStreamReader(instream) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }
       
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
	 * Return description of task
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader.readLine() with a loop" ;
	}

}
