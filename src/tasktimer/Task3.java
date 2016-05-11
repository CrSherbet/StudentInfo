package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Process all the words in a file (one word per line) using BufferedReader
 * and the lines() method which creates a Stream of Strings (one item per line).  
 * Then use the stream to compute summary statistics.
 * In a lambda you cannot access a local variable unless it is final,
 * so (as a cludge) we use an attribute for the count.
 * When this method is rewritten as a Runnable, it can be a non-static attribute
 * of the runnable.
 * Display summary statistics and elapsed time.
 * 
 * @author Warisara Inprom
 */
public class Task3 extends BufferedReaderTask {
	
	/**
	 * Attributes of class Task3.
	 */
	InputStream instream ;
    BufferedReader br ;
    IntCounter counter ;
    
    /**
	 * Constructor of class Task3.
	 */
	public Task3(){
		instream = Dictionary.getWordsAsStream();
		br = null;
		counter = new IntCounter();
	}

	/**
	 * Run class Task3.
	 */
	@Override
	public void run() {
        // This code uses Java's IntStream.average() method.
        // But there is no way to also get the count of items.
        // averageLength = br.lines().mapToInt( (word) -> word.length() )
        //                         .average().getAsDouble();
        // So instead we write out own IntConsumer to count and average the stream,
        // and use our IntConsumer to "consume" the stream.
        br.lines().mapToInt( word -> word.length() ).forEach( counter );
        // close the input
        try {
            br.close();
        } catch(IOException ex) { /* ignore it */ }
        out.printf("Average length of %,d words is %.2f\n", counter.getCount(), counter.average() );
	}
	
	/**
	 * Return description of task.
	 */
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}

}
