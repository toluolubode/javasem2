import java.util.ArrayList;

/**
 * Created by tbee on 2/23/17.
 */
public class MyStack implements Stack {

    Object[] stack;
    int index = 0;

    public MyStack(){
        stack = new Object[1];
    }
    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public Object peek() {
        if (index == 0){
            return null;
        }
        return stack[index-1];
    }

    @Override
    public Object pop() {
        if(index == 0){
            return null;
        }

        Object o = stack[index-1];
        stack[index-1] = null;
        index--;
        return o;
    }

    @Override
    public void push(Object element) {
        if(index >= stack.length){
            resize();
        }
        stack[index] = element;
        index++;
    }

    public void resize(){
        int length = stack.length +1;
        Object[] newStack = new Object[length];
        int index = 0;

        for(Object i : stack){
            newStack[index] = i;
            index++;
        }

        this.stack = newStack;
    }
}
