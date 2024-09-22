import java.util.Stack;

public class ReverseStack {
    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverse(s);
        insertLast(s, top);
    }

    public static void insertLast(Stack<Integer> s, int val) {
        if(s.isEmpty()) {
            s.push(val);
            return;
        }

        int temp = s.pop();
        insertLast(s, val);
        s.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(6);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
