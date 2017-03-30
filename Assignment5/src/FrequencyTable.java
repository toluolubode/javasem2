/**
 * The interface <strong>FrequencyTable</strong>. A frequency table
 * associates counts to keys. To be more precise, the interface should
 * be called CountTable since it stores the counts, not the
 * frequencies. Oh well.
 *
 * @author  Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public interface FrequencyTable {

    /** Returns the frequency value associated with this key.
     *
     *  @param key key whose frequency value is to be returned
     *  @return the frequency associated with this key
     */

    long get(String key);

    /** Creates an entry in the frequency table and initializes its
     *  count to zero.
     *
     *  @param key key with which the specified value is to be associated
     */

    void init(String key);

    /** The method updates the frequency associed with the key by one.
     *
     *  @param key key with which the specified value is to be associated
     */

    void update(String key);

    /** Returns the list of keys in order, according to the method
     *  <strong>compareTo</strong> of the key objects.
     *
     *  @return the list of keys in order
     */

    LinkedList<String> keys();

    /** Returns an array containing the frequencies of the keys in the
     *  order specified by the method <strong>compareTo</strong> of
     *  the key objects.
     *
     *  @return an array of frequency counts
     */

    long[] values();

    /** The size of the frequency table.
     *
     * @return the size of the frequency table
     */

    int size();
    
}
