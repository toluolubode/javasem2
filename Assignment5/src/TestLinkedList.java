/** Minimalist tests for LinkedList.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class TestLinkedList {

    public static void main(String[] args) {

	StudentInfo.display();

	LinkedList<Integer> xs;
	final int MAX_SIZE = 5;

	for (int stop = 0; stop<MAX_SIZE; stop++) {
	    for (int start = 0; start<=stop; start++) {

		System.out.println("start="+start+", stop="+stop);
	
		xs = new LinkedList<Integer>();

		for (int i=0; i<MAX_SIZE; i++) {
		    xs.addLast(i);
		}

		System.out.println(xs);

		Iterator<Integer> i = xs.iterator(start,stop);

		while (i.hasNext()) {
		    System.out.println(i.next());
		}

	    }
	}
    }

}

// > java TestLinkedList
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// start=0, stop=0
// {0,1,2,3,4}
// 0
// start=0, stop=1
// {0,1,2,3,4}
// 0
// 1
// start=1, stop=1
// {0,1,2,3,4}
// 1
// start=0, stop=2
// {0,1,2,3,4}
// 0
// 1
// 2
// start=1, stop=2
// {0,1,2,3,4}
// 1
// 2
// start=2, stop=2
// {0,1,2,3,4}
// 2
// start=0, stop=3
// {0,1,2,3,4}
// 0
// 1
// 2
// 3
// start=1, stop=3
// {0,1,2,3,4}
// 1
// 2
// 3
// start=2, stop=3
// {0,1,2,3,4}
// 2
// 3
// start=3, stop=3
// {0,1,2,3,4}
// 3
// start=0, stop=4
// {0,1,2,3,4}
// 0
// 1
// 2
// 3
// 4
// start=1, stop=4
// {0,1,2,3,4}
// 1
// 2
// 3
// 4
// start=2, stop=4
// {0,1,2,3,4}
// 2
// 3
// 4
// start=3, stop=4
// {0,1,2,3,4}
// 3
// 4
// start=4, stop=4
// {0,1,2,3,4}
// 4
