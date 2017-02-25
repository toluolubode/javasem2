/**
 * Created by tbee on 2/23/17.
 */
public class MyStack implements Stack {

    Object[] stack;
    int index = 0;

    public MyStack(int size){
        stack = new Object[size];
    }
    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public Object peek() {
        return null;
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public void push(Object element) {

    }
}
