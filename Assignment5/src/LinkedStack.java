/** Implements the interface <code>Stack</code> using linked elements.
 *
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class LinkedStack<E> implements Stack<E> {

    // Objects of the class Elem are used to store the elements of the
    // stack.
    
    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Reference to the top element
    
    private Elem<E> top;
    private Elem<E> rollTop;
    private boolean rolled = false;

    /** Returns <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     *
     * @return <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     */

    public boolean isEmpty() {
        return top == null;
    }

    /** Inserts an element onto the stack.
     *
     * @param value the element to be inserted
     */

    public void push(E value) {

	if (value == null) {
	    throw new NullPointerException();
	}
	
        top = new Elem<E>(value, top);
    }

    /** Returns the top element, without removing it.
     *
     * @return the top element
     */

    public E peek() {

	// pre-condition: the stack is not empty
	
        return top.value;
    }

    /** Removes and returns the top element.
     *
     * @return the top element
     */

    public E pop() {

	// pre-condition: the stack is not empty
	
        E saved = top.value;
        top = top.next;
        return saved;

    }

    /** Removes the top element of the stack. The element inserted at
     * the bottom of the stack.
     */

    public void unroll() {

	    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");


        if(top == null){
            return;
        }
        else if(top.next == null){
            return;
        }
        if(rollTop == null){
            rollTop = top;
        }
        else if(rollTop.next.next == null){
            E val = rollTop.next.value;
            rollTop.next = null;
            top = new Elem<E>(val, top);
            rollTop = null;


            return;
        }
        else {
            rollTop = rollTop.next;

        }

        unroll();

    }

    /** Removes the botttom element. The element is inserted on the
     * top of the stack.
     */

    public void roll() {


        if(top == null){
            return;
        }
        else if(top.next == null){
            return;
        }
        if(rollTop == null){
            rollTop = top;
        }
        else if(rollTop.next == null){
            rollTop.next = new Elem<E>(top.value, null);
            top = top.next;
            rollTop = null;


            return;
        }
        else {
            rollTop = rollTop.next;

        }
        //System.out.println(ToString(rollTop));

        roll();
	
    }



    /** Returns a string representation of the stack.
     *
     * @return a string representation
     */

    @Override public String toString() {
	StringBuffer stackStr = new StringBuffer("{");

	Elem<E> current = top;
	
	while (current != null) {
	    stackStr.append(current.value);
	    if (current.next != null) {
		stackStr.append(",");
	    }
	    current = current.next;
	}
	stackStr.append("}");

	return stackStr.toString();
    }

     public String ToString(Elem<E> s) {
        StringBuffer stackStr = new StringBuffer("{");

        Elem<E> current = s;

        while (current != null) {
            stackStr.append(current.value);
            if (current.next != null) {
                stackStr.append(",");
            }
            current = current.next;
        }
        stackStr.append("}");

        return stackStr.toString();
    }
    
}
