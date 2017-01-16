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


 	public static void main(String[] args) {
		int[] result= new int [args.length];
		for (int i = 0; i < args.length; i++) {
			result[i] = Integer.valueOf(args[i]);
		}
		System.out.println(getLongestRun(result));

    }
}
