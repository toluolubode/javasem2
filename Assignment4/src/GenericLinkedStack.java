public class GenericLinkedStack<E> implements Stack<E> {

    // E is the type of the elements of this stack.  The specific type
    // will specified when a reference is declared and a stack is
    // actually created. E.g.:
    //
    // Stack<Integer> nums;
    // nums = new GenericArrayStack<Integer>( 10 );


    private Node<E> store;
    private int top; // Designates the first free cell
    // Returns true if this ArrayStack is empty

    private static class Node<T>{
        private T item;
        private Node<T> next;

        private Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
    @SuppressWarnings( "unchecked" )

    public GenericLinkedStack(){
        store.item= null;
        top= 0;
    }
    public boolean isEmpty() {
        if (store.item == null){
            return false;
        }
        return true;
    }

    public void push( E elem ) throws EmptyStackException {

        if (elem == null){
            throw new EmptyStackException(elem);
        }

        store = new Node<E>(elem, store);


        top++;
    }

    public E pop() {

        E elem;

        elem= store.item;

        store=store.next;
        top--;

        return elem;
    }

    public E peek() {
        // pre-condition: ! isEmpty()

        return store.item;
    }
}
