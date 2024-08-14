package arrays;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Vector;

/*
   @author Austin Oyugi
   @since 14/08/2024
   @mail austinoyugi@gmail.com
*/
public class MinStack {

    private static Vector<Integer> vector;

    public MinStack() {
        vector  = new Vector<>();
    }

    // [] -> push(4) -> [4] -> push(3) -> [4,3]
    public void push(int val) {
        vector.addElement(val);
    }

    // [4,3] -> pop
    // Removes last added element
    public void pop() {
        if (vector.isEmpty()) throw new EmptyStackException();
        vector.remove(vector.size() -1);
    }

    public int top() {
        if (vector.isEmpty()) throw new EmptyStackException();
        return vector.get(vector.size() -1);
    }

    public int getMin() {
        if (vector.isEmpty()) throw new EmptyStackException();
        return vector.stream().min(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(EmptyStackException::new);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        System.out.println("Min " + minStack.getMin()); // return 0
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // return 2
        System.out.println("Min: "+ minStack.getMin()); // return 1
    }
}
