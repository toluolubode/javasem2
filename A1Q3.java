//Name: Ogunsanya Toluwani Damilola
//Student-No: 8677256
//Section: ITI1121-C
//ASSIGNMENT 1 Q3

//Name: Olubode Toluwanimi
//Student-No: 8696226
//Section: ITI1121-A
//ASSIGNMENT 1 Q3

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
			int maxLength= 0;
			while (i< elems.length-1){
				int length =1;
				while (i<elems.length-1 && elems[i]==elems[i+1]){
					length= length+1;
					i=i+1;
				if (length> maxLength) {
					maxLength=length;
				// i=i+1;
				}

				}
        i+=1;
			}
			return maxLength;
    }


 	public static void main(String[] args) {

    StudentInfo studentInfo = new StudentInfo();
    studentInfo.display();

		int[] result= new int [args.length];
		for (int i = 0; i < args.length; i++) {
			result[i] = Integer.parseInt(args[i]);
		}
		System.out.println(getLongestRun(result));

    }
}
