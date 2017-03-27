public class GenericLinkedStack<E> implements Stack<E> {

    // E is the type of the elements of this stack.  The specific type
    // will specified when a reference is declared and a stack is
    // actually created. E.g.:
    //
    // Stack<Integer> nums;
    // nums = new GenericArrayStack<Integer>( 10 );


    private Node store;
    private int top; // Designates the first free cell
    // Returns true if this ArrayStack is empty

    private class Node{
      private E item;
      private Node next;
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
          throw new EmptyStackException(elem)
        }
        Node b=n;
        n= new Node();

        n.item= elem;
        n.next= b;
        top++;
    }

    public E pop() {

        E elem;

        elem= n.item;
        n=n.next;
        top--;

        return elem;
    }

    public E peek() {
        // pre-condition: ! isEmpty()

        return n.item;
    }
}
