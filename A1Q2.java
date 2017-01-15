public class A1Q2 {

	/**
     * Returns true if elems contains at least two consecutive
     * identical number, false otherwise
     *
     *   @param elems the list of integers, assumed to be non null
     *  @return true if elems contains at least two consecutive
     * identical number, false otherwise
     */

    private static boolean hasTwoLengthRun(int[] elems) {

			for (int i=0; i<elems.length; i++ ) {
				if (elems[i]==elems[i+1]) {
					return true;

				}
			}
			return false;
    }

 	public static void main(String[] args) {
		System.out.println(hasTwoLengthRun(new int[]{0, 1, 2, 3, 4, 5, 5 }));

    }
}
