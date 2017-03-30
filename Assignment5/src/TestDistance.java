import java.io.IOException;
import java.io.FileNotFoundException;
    
/** Minimalist tests for the class Distance.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class TestDistance {

    public static void main(String[] args) {

	StudentInfo.display();

	String a = "ACACACACACACACACACACACACACACACACACACACAC";
	String b = "ACACACACACACACACACACCACACACACACACACACACAC";
	String c = "ACACACACACACACACACACCACACACACACACACACCCAC";
	String d = "ACACACACACACACACACACCACACACACACACACACACACACACACACACACACACACACCACACACACACACACACACAC";

	System.out.println(Distance.compare(5, a, a));
	System.out.println(Distance.compare(5, a, b));
	System.out.println(Distance.compare(5, a, c));
	System.out.println(Distance.compare(5, a, d));
	System.out.println(Distance.compare(5, b, c));
	System.out.println(Distance.compare(5, b, d));
	System.out.println(Distance.compare(5, c, d));

	String e = null, f = null;
	
	try {
	    e = Utils.readFile("data/NC_000913.txt");
	    f = Utils.readFile("data/NC_000908.txt");
	} catch (IOException exception) {
	    System.err.println(exception);
	    System.exit(-1);
	}

	Utils.setType("LINEAR");

	long start = System.nanoTime(), stop;
	
	System.out.println(Distance.compare(5, e, f));

	stop = System.nanoTime();
	
	System.out.println("time = " + (stop-start) + " nano seconds");

	Utils.setType("TREE");

	start = System.nanoTime();
	
	System.out.println(Distance.compare(5, e, f));

	stop = System.nanoTime();
	
	System.out.println("time = " + (stop-start) + " nano seconds");

	
    }
    
}

// > java TestDistance
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// 0.0
// 0.009130752373995615
// 0.031044558071585078
// 0.008218277449046676
// 0.008765522279035794
// 2.4012498024971943E-5
// 0.00946380572160198
// 0.0012225189741013151
// time = 10771698130 nano seconds
// 0.0012225189741013151
// time = 500109497 nano seconds
