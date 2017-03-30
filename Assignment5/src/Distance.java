/**
 * Implements the k-tuple distance of Yang et al.: Yang et al. (2008)
 * Performance comparison between k-tuple distance and four
 * model-based distances in phylogenetic tree
 * reconstruction. Nucleic Acids Res. 36(5) :e33,
 * doi:10.1093/nar/gkn075.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Distance {

    // Helper method. Uses a queue to generate all possible keys of
    // size k.
    
    private static void init(FrequencyTable t, int k) {

	String[] alphabet = {"A", "C", "G", "T"};

	LinkedList<String> keys = new LinkedList<String>();

	for (String a : alphabet) {
	    keys.addLast(a);
	}

	boolean done = false;

	while (! done) {

	    String key = keys.get(0);

	    if (key.length() == k) {
		done = true;
	    } else {
		keys.removeFirst();
		for (String a : alphabet) {
		    keys.addLast(a+key);
		}
	    }
	    
	}

	for (int i=0; i<keys.size(); i++) {
	    t.init(keys.get(i));
	}

    }

    // Helper method. Extracts the k-tuples from s and updates the
    // frequency table.


    private static void update(FrequencyTable t, int k, String s) {
	for (int i=0; i < s.length() - k + 1; i++) {
            t.update(s.substring(i, i+k));
        }
    }

    /** Returns the k-tuples distance of the two input strings.
     *
     * @param k the size of the k-tuples (k-grams)
     * @param a input string
     * @param b input string
     * @return the k-tuples distance
     */
    
    public static double compare(int k, String a, String b) {

	FrequencyTable fa = Utils.getFrequencyTable();
	FrequencyTable fb = Utils.getFrequencyTable();

	init(fa, k);
	init(fb, k);

	update(fa, k, a);
	update(fb, k, b);

	long[] as = fa.values();
	long[] bs = fb.values();

	assert as.length == bs.length;

	double distance = 0.0;

	for (int i=0; i<as.length; i++) {

	    double x, y;

	    x = as[i] / (double) (a.length() - k + 1);
	    y = bs[i] / (double) (b.length() - k + 1);

	    distance += Math.pow(x - y, 2.0);
	    
	}
	
	return distance;
    }

}
