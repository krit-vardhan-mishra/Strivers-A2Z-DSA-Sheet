import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(val, stack2.peek()));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
