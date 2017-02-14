 /**
 * The class  <b>BirthdayParadox</b> is used to
 * simulated the so-called Birthday paradox, and uses
 * the class <b>Statistics</b> to store the results of
 * the experiments.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class BirthdayParadox {


	/**
     * Random generator
     */
	private static java.util.Random generator = new java.util.Random();


	/**
     * Runs the series of experiments, and stores the result into
     * a Statistics object
     *
     * @param range the size of the set from which random number are drawn
     * @param numberOfRuns the number of experiments to run
	 *
	 * @return a reference to a Statistics instance that holds the result
	 * of the experiment
     */
 	public static Statistics runExperiments(int range, int numberOfRuns){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION

		Statistics stats;
		stats = new Statistics(numberOfRuns);
		int value;

		for (int i = 0; i< numberOfRuns; i++) {
			//System.out.println(i);
			boolean found = false;
			int[] data = new int[365];
			int k = 0;

			while(!found){
				value = oneRun(range);
				data[k] = value;
				found = isPresent(data, value);

				if(found){
					System.out.println(k);
					//System.out.println("found");
					stats.updateStatistics(k);
				}

				k = k+1;
			}

		}

		System.out.println(stats);

		return stats;

	}

 	/**
     * Runs a single experiment.
     * The parameter range defines the size of the set from which
     * the experiment is drawn
     *
     * @param range the size of the set from which random number are drawn
     *
	 * @return the number of random draw in the set that the method
	 * used before drawing the same element for the second time
     */

 	private static int oneRun(int range){

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		int number;

		number = generator.nextInt(range)+1;

		//System.out.println("RANDOM NUMBER: "+ number);

		return number;
	}

	public static boolean isPresent(int[] days, int value){

		for(int i = 0; i < days.length; i++){
			if (days[i] == value){
				return true;
			}
		}

		return false;

	}


     /**
     * Main method. Runs the experiments numberOfRunstimes,
     * with increasingly large sets (increment in size:step).
     * Stop once the size reaches max.
     * plots the result.
     *
     * @param args if not empty, contains the runtime values for
     * step, max and numberOfRuns
     */
     	public static void main(String[] args) {

// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
		StudentInfo ourInfo = new StudentInfo();

		ourInfo.display();

		ITI1121Chart chart = new ITI1121Chart("AGE DISTRIBUTION");

		for (int i = 100; i<=10000; i+=100) {
			//System.out.println("I: " + i);
			Statistics a = runExperiments(i, 1000);
			chart.addDataPoint(a.standardDeviation(), a.standardDeviation(), a.standardDeviation());
			chart.addPolynome(5);
			a = null;
		}

		chart.render();

	}

}
