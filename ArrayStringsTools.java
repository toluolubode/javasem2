/**
 * The class <b>ArrayStringsTools</b> provides a series of
 * static methods that mimic some of the methods built in 
 * Python
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class ArrayStringsTools{

	/** 
     * Prints the strings contained in arrayOfStrings
     * 
     *   @param arrayOfStrings the array of Strings
     *   @param currentSize the number of strings in the arrayOfStrings,
     *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
     */

	public static void printArray(String[] arrayOfStrings, int currentSize){
		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.printArray: wrong call");
			return ;
		}
		for(int i = 0; i < currentSize-1; i++){
			System.out.print(arrayOfStrings[i] + ", ");
		}
		System.out.println(arrayOfStrings[currentSize-1]);
	}

	/** 
     * Does a lexicographic sorting of arrayOfStrings. 
     * It simply relies on the sort(Object[]) method
	 * of java.util.Arrays. 
	 * Note that it sorts in lexicographic order, so 
	 * "10" is before "2", "A" is before "Q" etc. 
	 * This is not important for this game, but wouldn't 
	 * be suitable in some other cases
     * 
     *   @param arrayOfStrings the array of Strings
     *   @param currentSize the number of strings in the arrayOfStrings,
     *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
     */
	public static void sortArray(String[] arrayOfStrings, int currentSize){
		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.sortArray: wrong call");
			return ;
		}
		java.util.Arrays.sort(arrayOfStrings, 0, currentSize );
	}



	/** 
     * Randomly shuffles arrayOfStrings. 
     * 
     *   @param arrayOfStrings the array of Strings
     *   @param currentSize the number of strings in the arrayOfStrings,
     *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
     */
	public static void shuffleArray(String[] arrayOfStrings, int currentSize){
		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.shuffleArray: wrong call");
			return ;
		}
		
		java.util.Random generator = new java.util.Random();

		for(int i = currentSize-1 ; i > 1 ; i--){
			swapItems(arrayOfStrings, i,generator.nextInt(i-1));
		}
	}

	private static void swapItems(String[] arrayOfStrings, int i, int j){
		String intermediate = arrayOfStrings[i];
		arrayOfStrings[i]=arrayOfStrings[j];
		arrayOfStrings[j]=intermediate;
	}


	/** 
     * Removes the string at  arrayOfStrings[itemToRemove] and
     * 
     *   @param arrayOfStrings the array of Strings
     *   @param currentSize the number of strings in the arrayOfStrings,
     *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
     *   @param itemToRemove index of the item to remove from arrayOfStrings
     *   @return the new size of the modified arrayOfStrings
     */

	public static int removeItemByIndex(String[] arrayOfStrings, int currentSize, int itemToRemove){

		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.removeItemByIndex: wrong call");
			return currentSize;
		}
		if( itemToRemove < 0 || itemToRemove >= currentSize ) {
			System.out.println("ArrayStringsTools.removeItem: item " 
				+ itemToRemove + " out of bounds. Array Unchanged.");
			return currentSize;
		}

		int i;
		for( i = itemToRemove; i < currentSize-1; i++){
			arrayOfStrings[i] = arrayOfStrings[i+1];
		}
		arrayOfStrings[i]= null;
		return currentSize-1;
	}

	/** 
     * Appends itemToAdd at the end of arrayOfStrings 
     * 
     * 
     *   @param arrayOfStrings the array of Strings
     *   @param currentSize the number of strings in the arrayOfStrings,
     *			stored from arrayOfStrings[0] to arrayOfStrings[currentSize-1] 
     *   @param itemToAdd the String to add to  arrayOfStrings
     *   @return the new size of the modified arrayOfStrings
     */

 	public static int appendItem(String[] arrayOfStrings, int currentSize, String itemToAdd){

		if( arrayOfStrings == null || currentSize > arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.appendItem: wrong call");
			return currentSize;
		}

		if( currentSize == arrayOfStrings.length) {
			System.out.println("ArrayStringsTools.appendItem: array full. Array Unchanged.");
			return currentSize;
		}
		arrayOfStrings[currentSize++]=itemToAdd;
		return currentSize;
	} 	
}