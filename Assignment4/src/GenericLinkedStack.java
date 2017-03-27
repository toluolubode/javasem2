// public class GenericArrayStack<E> implements Stack<E> {
//
//     // E is the type of the elements of this stack.  The specific type
//     // will specified when a reference is declared and a stack is
//     // actually created. E.g.:
//     //
//     // Stack<Integer> nums;
//     // nums = new GenericArrayStack<Integer>( 10 );
//
//     // Instance variables
//
//     private E[] elems; // Used to store the elements of this ArrayStack
//     private int top; // Designates the first free cell
//
//     @SuppressWarnings( "unchecked" )
//
//     // Constructor
//     public GenericArrayStack( int capacity ) {
// 	elems = (E[]) new Object[ capacity ];
// 	// elems = new E[ capacity ];
// 	top = 0;
//     }
//
//     // Returns true if this ArrayStack is empty
//     public boolean isEmpty() {
// 	return top == 0;
//     }
//
//     public void push( E elem ) {
// 	// pre-condition: ! isFull()
//
// 	elems[ top ] = elem;
// 	top++;
//
//     }
//     public E pop() {
// 	// pre-condition: ! isEmpty()
//
// 	E saved;
//
// 	top--;
// 	saved = elems[ top ];
// 	elems[ top ] = null;
//
// 	return saved;
//     }
//
//     public E peek() {
// 	// pre-condition: ! isEmpty()
//
// 	return elems[ top-1 ];
//     }
// }

public class GenericLinkedStack<E> implements Stack<E> {

    // E is the type of the elements of this stack.  The specific type
    // will specified when a reference is declared and a stack is
    // actually created. E.g.:
    //
    // Stack<Integer> nums;
    // nums = new GenericArrayStack<Integer>( 10 );
     static class Elem<Q>{
         Q data;
         Elem<Q> next;

        private Elem(Q data, Elem<Q> next){
            this.data = data;
            this.next = next;
        }

        public Elem<Q> getNext(){
            return next;
        }
    }
    // Instance variables


    private Elem<E> top;

    public GenericLinkedStack(){
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push( E elem ) {
        // pre-condition: ! isFull()
        top = new Elem<E>(elem, top);


    }
    public E pop() {
        // pre-condition: ! isEmpty()
        if(isEmpty()) {
            System.out.println("isEmpty");
            return null;
        }

        E data = top.data;
        top = top.next;

        System.out.println(data);

        return data;
    }

    public E peek() {
        // pre-condition: ! isEmpty()
        if(isEmpty())
            return null;

        return top.data;
    }




}
