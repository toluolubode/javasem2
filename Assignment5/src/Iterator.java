import java.util.NoSuchElementException;

/** An <code>Iterator</code> returns the elements of collection one at a time
 * provinding an efficient mean to traverse a data structure.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public interface Iterator<E> {

    /**
     * Returns true if the iteration has more elements. (In other
     * words, returns true if next would return an element rather than
     * throwing an exception.)
     *
     * @return true if the iterator has more elements.
     */

    boolean hasNext();

    /**
     * Returns the next element in the interation.
     *
     * @return the next element in the iteration.
     * @throws NoSuchElementException iteration has no more elements.
     */

    E next();

}
