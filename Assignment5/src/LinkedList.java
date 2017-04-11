import java.util.NoSuchElementException;

/** Implements a linked list. The elements are doubly linked. The list
 *  is circular and has a dummy node.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class LinkedList<E> {

    // Objects of the class Elem are used to store the elements of the
    // list.
    
    private static class Elem<T> {

        private final T value;

        private Elem<T> previous;
        private Elem<T> next;

        private Elem(T value, Elem<T> previous, Elem<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // An inner (non-static) class is used to implement the interface
    // Iterator.

    private class LinkedListIterator implements Iterator<E> {
    
        private Elem<E> current;
        private int start, step, stop, count;
        private boolean stopper = false;
    
        private LinkedListIterator() {
            current = head;
            start = 0;
        }

        private LinkedListIterator(int stop){
            current = head;
            this.stop = stop;
            this.stopper = true;
            count= 0;
            step=0;
            start = 0;
        }

        private LinkedListIterator(int start, int stop){

            if(start >= LinkedList.this.size()){
                throw new IndexOutOfBoundsException("You can't start there mate!");
            }

            for (int i = 0; i <= start; i++){
                if(i == 0) current = head;

                else current = head.next;
            }

            this.stop = stop;
            this.stopper = true;
            count= 0;
            this.start = start;
        }

        private LinkedListIterator(int start, int step, int stop){

            if(start >= LinkedList.this.size()){
                throw new IndexOutOfBoundsException("You can't start there mate!");
            }

            for (int i = 0; i <= start; i++){
                if(i == 0) current = head;

                else current = head.next;
            }

            this.stop = stop;
            this.stopper = true;
            count= 0;
            this.start = start;
        }
    
        public E next() {
      
            if (current.next == head) {
        	    throw new NoSuchElementException();
            }

            if(stopper && count < stop) {

                if(step>0) step(current);
                else{
                    current = current.next;
                    count++;
                }
            }
            else if(!stopper){
                if(step > 0) step(current);
                else current = current.next;
            }
            else{
                return null;
            }

      
            return current.value ;
        }

        private void step(Elem<E> current){
            for(int i = 0; i < step; i++){
                if(stopper && count == stop) break;

                current = current.next;
                count++;
            }
        }
    
        public boolean hasNext() {
            if(stopper){
                return !(count == stop);
            }
            return current.next != head;
        }
    
    }
    
    private final Elem<E> head;
    private int size;
    
    public LinkedList() {
        head = new Elem<E>(null, null, null);
        head.next = head;
        head.previous = head;
        size = 0;
    }

    /**
     * Returns an iterator for this list.
     *
     * @return an iterator for this list
     */
  
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    
    /**
     * Returns an iterator for this list stopping at a specified position.
     *
     * @param stop the index of the last element of the iteration
     * @return an iterator for this list
     */

    public Iterator<E> iterator(int stop) {

	    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

        return new LinkedListIterator(stop);
	
    }
    
    /**
     * Returns an iterator for this list that starts at a specified
     * position and stops at a specified position.
     *
     * @param start the index of the first element of the iteration
     * @param stop the index of the last element of the iteration
     * @return an iterator for this list
     */

    public Iterator<E> iterator(int start, int stop) {

        return new LinkedListIterator(start, stop);
	
    }

    /** Returns the size of the list.
     *
     * @return the size of the list
     */
    
    public int size() {
        return size;
    }

    // Helper method. Adds an element to the list after the specified
    // node.

    private void addAfter(Elem<E> before, E obj) {

        Elem<E> after = before.next;

        before.next = new Elem<E>(obj, before, after);
        after.previous = before.next;

        size++;

    }

    /** Inserts the specified element at the beginning of this list.
     * 
     * @param obj the object to be added
     */

    public void addFirst(E obj) {

	if (obj == null) {
	    throw new NullPointerException();
	}
	
	addAfter(head, obj);
	
    }

    /** Inserts the specified element at the end of this list.
     * 
     * @param obj the object to be added
     */

    public void addLast(E obj) {
	
	if (obj == null) {
	    throw new NullPointerException();
	}
	
	addAfter(head.previous, obj);

    }
    
    /** Inserts the specified element at a specified position of this list.
     * 
     * @param pos the specified position
     * @param obj the object to be added
     * @throws IndexOutOfBoundsException if the specified position is out of range 
     */

    public void add(int pos, E obj) {

	if (obj == null) {
	    throw new NullPointerException();
	}
	
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Elem<E> before;
        before = head;

        for (int i=0; i<pos; i++) {
            before = before.next;
        }

	addAfter(before, obj);

    }

    // Helper method. Removes the specified node.

    private void remove(Elem<E> current) {

        Elem<E> before = current.previous, after = current.next;

        before.next = after;
        after.previous = before;

        size--;

    }

    /** Removes the first element from this list.
     */

    public void removeFirst() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

	    remove(head.next);
    }

    /** Removes the last element from this list.
     */

    public void removeLast() {

        if (size == 0) {
            throw new NoSuchElementException();
        }
	
	remove(head.previous);

    }
    
    /** Remove the element at the specified position.
     *
     * @param pos the specified position
     * @throws IndexOutOfBoundsException if the specified position is out of range 
     */

    public void remove(int pos) {

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Elem<E> current;
        current = head.next;

        for (int i=0; i<pos; i++) {
            current = current.next;
        }

	remove(current);

    }

    /** Returns the element found at the specied position.
     *
     * @param pos the specified position
     * @return the element found at the specified position
     * @throws IndexOutOfBoundsException if the specified position is out of range 
     */

    public E get(int pos) {

	if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Elem<E> current;
        current = head.next;

        for (int i=0; i<pos; i++) {
            current = current.next;
        }

	return current.value;
    }

    /** Returns a String representation of this list.
     *
     * @return a String representation of this list
     */

    public String toString() {

	StringBuffer str = new StringBuffer("{");
	Elem<E> p = head.next;

	while (p != head) {
	    str.append(p.value);
	    if (p.next != head) {
		str.append(",");
	    }
	    p = p.next;
	}
	str.append("}");
	return str.toString();
    }
}
