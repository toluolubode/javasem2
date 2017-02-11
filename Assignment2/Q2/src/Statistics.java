
/**
 * The class  <b>Statistics</b> accumulates the results of
 * the experiments. It know ahead of time how many experiments
 * will be run, and provides at the end the min, the max, the
 * average and the standard deviation for the data.
 *
 * <b> this class should not use classes such as Array, 
 * Lists etc. </b> to store the data, only prinitive types 
 * and java arrays.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */
public class Statistics {

// ADD HERE INSTANCE VARIABLES DECLARATION

	/** 
     * Constructor.
     * 
     * @param numberOfRuns the number of experiments that will be run
     */
 	public  Statistics(int numberOfRuns){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}
	
	/** 
     * Updates statistics after one experiment.
     * This method cannot be called more times than the 
     * paramter that was passed in the constructor. If
     * it is, an error message should be printed and
     * no change should occur.
     *   @param value the result of the new experiment
     */
	public void updateStatistics(int value){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}
	

	/** 
     *   @return the current average of the values passed
     * to the method updateStatistic
     */
	public double average(){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}


	/** 
     *   @return the current standard deviation of the values passed
     * to the method updateStatistic
     */
	public double standardDeviation(){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}

	/** 
     *  @return Returns the complete statistics information:
     * current minimum, current maximim, current average and
     * current standard deviation. For the last two, only two 
     * digits decimals are shown
     */
	public String toString(){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

	}

}
