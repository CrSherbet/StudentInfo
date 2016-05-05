package tasktimer;
/**
 * Computing elapsed time 
 * @author Warisara
 *
 */
public class StopWatch {
	/**
	 * Attributes of class StopWatch
	 */
	private long startTime;
	private long stopTime;
	private boolean running;

	/**
	 * Catching start time
	 */
	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * Catching stop time
	 */
	public void stop() {
		stopTime = System.nanoTime();
	}

	/**
	 * Calculating elapsed time
	 * @return  elapsed time
	 */
	public double getElapsed() {
		return stopTime - startTime;
	}

}
