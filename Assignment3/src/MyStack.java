import java.util.ArrayList;

/**
 * Created by tbee on 2/23/17.
 */
public class MyStack implements Stack {

    ArrayList<Object> stack;
    int index = -1;

    public MyStack(){
        stack = new ArrayList<>();
    }
    @Override
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    @Override
    public Object peek() {
        if (index == -1){
            return null;
        }
        return stack.get(index);
    }

    @Override
    public Object pop() {
        if(index == 0){
            return null;
        }

        Object o = stack.get(index);
        stack.remove(index);
        return o;
    }

    @Override
    public void push(Object element) {
        stack.add(element);
        index++;
    }
}
