public class A1Q3 {

	/**
     * Returns the longest run of consecutive identical elements in elems.
     * We assume that the list is not null.
     *
     *   @param elems the list of integers
     *   @return size of the longest run
     */

    private static int getLongestRun(int[] elems) {
			int i=0;
			int maxLength= 1;
			while (i< elems.length){
				int length =1;
				while (i<elems.length && elems[i]==elems[i+1]){
					length= length+1;
					i=i+1;
				if (length> maxLength) {
					maxLength=length;
				i=i+1;
				}
				}
			}
			return maxLength;
    }

 	/**
     * The main method of this program. Gets an array of
     * strings as input parameter. The array is assumed to
     * be non-null, and all the strings in the array are
     * parsable as integer.
     *
     * The function prints out the longest run of consecutive
     * identical integers parsed in args
     * @param args space-separated list of strings parsable as integers
	 */

 	public static void main(String[] args) {
		System.out.println(getLongestRun(new int[]{}));

    }
}
