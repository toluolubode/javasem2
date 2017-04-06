import java.util.NoSuchElementException;

/** Implements the interface <code>FrequencyTable</code> using linked
 *  elements. The linked structure is circular and uses a dummy node.
 *
 * @author Marcel Turcotte (turcott@eecs.uottawa.ca)
 */

public class LinearFrequencyTable implements FrequencyTable {

    // Linked elements

    private static class Elem {

        private String key;
        private long count;
        private Elem previous;
        private Elem next;

        private Elem(String key, Elem previous, Elem next) {
            this.key = key;
            this.count = 0;
            this.previous = previous;
            this.next = next;
        }

    }

    private Elem head;
    private int size;

    /** Constructs and empty <strong>FrequencyTable</strong>.
     */

    public LinearFrequencyTable() {
        head = new Elem(null, null, null); // dummy node
        head.previous = head; // making the dummy node circular
        head.next = head; // making the dummy node circular
        size = 0;
    }

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */

    public int size() {
	return size;
    }
  
    /** Returns the frequency value associated with this key.
     *
     *  @param key key whose frequency value is to be returned
     *  @return the frequency associated with this key
     *  @throws NoSuchElementException if the key is not found
     */

    public long get(String key) {

        if(key == null) {
            throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
        }

	    Elem elem = head;


	    while (elem != null){
	        if(elem.key.equals(key)){
	            return elem.count;
            }
        }

        return 0;
	
    }

    /** Creates an entry in the frequency table and initializes its
     *  count to zero. The keys are kept in order (according to their
     *  method <strong>compareTo</strong>).
     *
     *  @param key key with which the specified value is to be associated
     *  @throws IllegalArgumentException if the key was alreaddy present
     */

    public void init(String key) {

	//throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
        if(head.next == null){
            head = new Elem(key, null, null);
        }
        else {
            head = new Elem(key, null, head);
            head.next.previous = head;
        }
    }

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     *  @throws NoSuchElementException if the key is not found
     */

    public void update(String key) {
	
	    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
	    Elem newHead = head;

	    while (head.key != null){
	        if(head.key.equals(key)){
	            head.count++;
	            break;
            }
        }

        head = newHead;


    }

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    public LinkedList<String> keys() {

	    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");
        Elem newHead = head;
        LinkedList<String> linkedList = new LinkedList<>();

        while (newHead.key != null){
            int size = linkedList.size();
            String key = newHead.key;
            if(size == 0){
                linkedList.add(0, key);
            }
            else{
                int i = 0;
                Iterator<String> iterator = linkedList.iterator();
                while (iterator!=null && iterator.hasNext()){
                    String temp = linkedList.get(i);
                    if(temp.compareTo(key)<0){
                        linkedList.add(i, key);
                    }
                    i++;
                }
            }
        }

        return linkedList;
    }

    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    public long[] values() {

	    //throw new UnsupportedOperationException("IMPLEMENT THIS METHOD");

        Elem newHead = head;
        long[] valuesList = new long[size()];
        int i = 0;

        while(size() > 0 && i < size()){
            valuesList[i] = newHead.count;
            newHead = newHead.next;
            i++;
        }
        sort(valuesList);

        return valuesList;

    }

    /** Returns a <code>String</code> representations of the elements
     * of the frequency table.
     *  
     *  @return the string representation
     */

    public String toString() {

        StringBuffer str = new StringBuffer("{");
        Elem p = head.next;

        while (p != head) {
            str.append("{key="+p.key+", count="+p.count+"}");
            if (p.next != head) {
            str.append(",");
            }
            p = p.next;
        }
        str.append("}");
        return str.toString();

    }

    private void sort(long[] vals){
        for (int i = 1; i < vals.length; i++){
            long temp = vals[i];
            int pos = i;

            while(pos > 0 && vals[pos-1] > vals[pos]){
                vals[pos] = vals[pos-1];
                pos--;
            }

            vals[pos] = temp;
        }
    }

}
