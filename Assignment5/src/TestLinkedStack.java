/** Minimalist tests for LinkedStack.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class TestLinkedStack {

    public static void main(String[] args) {

	StudentInfo.display();

	LinkedStack<Integer> s;

	s = new LinkedStack<Integer>();
	System.out.println(s);

	s.unroll();
	System.out.println(s);
	
	for (int i=0; i<5; i++) {
	    s.push(i);
	    System.out.println(s);
	    s.unroll();
	    System.out.println(s);
	}

	s = new LinkedStack<Integer>();
	System.out.println(s);

	s.roll();
	System.out.println(s);
	
	for (int i=0; i<5; i++) {
	    s.push(i);
	    System.out.println(s);
	    s.roll();
	    System.out.println(s);
	}

    }
    
}

// > java TestLinkedStack
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// {}
// {}
// {0}
// {0}
// {1,0}
// {0,1}
// {2,0,1}
// {1,2,0}
// {3,1,2,0}
// {0,3,1,2}
// {4,0,3,1,2}
// {2,4,0,3,1}
// {}
// {}
// {0}
// {0}
// {1,0}
// {0,1}
// {2,0,1}
// {0,1,2}
// {3,0,1,2}
// {0,1,2,3}
// {4,0,1,2,3}
// {0,1,2,3,4}
