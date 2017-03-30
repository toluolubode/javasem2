/** The abstract data type <code>Stack</code>.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public interface Stack<E> {
    
    /** Returns <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     *
     * @return <code>true</code> if this stack is empty, and
     * <code>false</code> otherwise.
     */
    
    boolean isEmpty();
    
    /** Returns the top element, without removing it.
     *
     * @return the top element
     */
    
    E peek();
    
    /** Removes and returns the top element.
     *
     * @return the top element
     */
    
    E pop();
    
    /** Inserts an element onto the stack.
     *
     * @param element the element to be inserted
     */
    
    void push( E element);
}
