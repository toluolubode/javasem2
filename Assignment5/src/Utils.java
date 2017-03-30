import java.io.*;

/** Helper methods for this assignment.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Utils {

    private static String type = "LINEAR";

    /** The method is used to specify the type of object to be
     * returned by the method getFrequencyTable.
     *
     * @param value the type of object to be returned by the method getFrequencyTable
     */
    
    public static void setType(String value) {

	if (value == null) {
	    throw new NullPointerException();
	}

	if (! value.equals("LINEAR") && ! value.equals("TREE")) {
	    throw new IllegalArgumentException(value);
	}

	type = value;	
    }

    /** A factory method returning an object implementing the
     * interface FrequencyTable. The actual type depends on the
     * current selection.
     *
     * @return an object implementing the interface FrequencyTable
     */
    
    public static FrequencyTable getFrequencyTable() {

	if (type.equals("LINEAR")) {
	    return new LinearFrequencyTable();
	} else if (type.equals("TREE")) {
	    return new TreeFrequencyTable();
	} else {
	    throw new AssertionError(); // can't happen
	}
    }

    /** Reads a file and returns its content as a String.
     *
     * @param name the name of the file
     * @return a string
     * @throws IOException if an I/O error occurs.
     * @throws FileNotFoundException if the file cannot be found
     */
    
    public static String readFile(String name) throws IOException, FileNotFoundException {

        String line;
        StringBuffer buffer;
        BufferedReader input;
            
        input = new BufferedReader(new InputStreamReader(new FileInputStream(name)));

        buffer = new StringBuffer();

        while ((line = input.readLine()) != null) {
            buffer.append(line);
        }

        input.close();

        return buffer.toString();
    }

}
