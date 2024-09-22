import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()) {
            return s;
        }

        int top = s.pop();
        sort(s);
        insert(s, top);
        return s;
    }

    public static void insert(Stack<Integer> s, int num) {
        if(s.isEmpty() || s.peek() <= num) {
            s.push(num);
            return;
        }

        int bot = s.pop();
        insert(s, num);
        s.push(bot);
    }

    public static void main(String[] args) {
        Stack<Integer> num = new Stack<>();
        num.push(3);
        num.push(2);
        num.push(1);

        System.out.println(num);
        System.out.println(sort(num));
    }
}
