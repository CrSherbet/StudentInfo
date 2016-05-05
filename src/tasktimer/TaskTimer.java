package tasktimer;

import static java.lang.System.out;

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer
{
	/**
	 * Runs the task and prints how much time was used
	 * @param task is the task that we want to run
	 */
    public static void execAndPrint( Runnable task ){
    	StopWatch watch = new StopWatch();
    	out.println(task.toString());
    	watch.start();
    	task.run();
    	watch.stop();
    	out.printf("Elapsed time is %f sec\n",(watch.getElapsed())*1.0E-9 );
    }
    
    /** Run all the tasks. */
    public static void main(String [] args) {
    	execAndPrint( new Task1() );
    	execAndPrint( new Task2() );
    	execAndPrint( new Task3() );
    	execAndPrint( new Task4() );
    	execAndPrint( new Task5() );
    	execAndPrint( new Task6() );
    	
    }
    
}
