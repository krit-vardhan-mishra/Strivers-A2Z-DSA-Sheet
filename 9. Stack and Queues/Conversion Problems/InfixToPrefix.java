import java.util.HashMap;
import java.util.Stack;

public class InfixToPrefix {

    public static String infixToPrefix(String exp) {
        exp = reverse(exp);

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> priority = new HashMap<>();

        priority.put('-',1);
        priority.put('+',1);
        priority.put('/',2);
        priority.put('*',2);
        priority.put('^', 3);


        for (int i = 0; i < exp.length(); i++) {
            char current = exp.charAt(i);

            if(Character.isDigit(current) || Character.isAlphabetic(current)) {
                res.append(current);
            } else if(current == '(') {
                stack.push(current);
            } else if(current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                while (!stack.isEmpty() && priority.containsKey(stack.peek()) && priority.get(current) <= priority.get(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res.reverse();
        
        return res.toString();
    }

    public static String reverse(String s) {
        StringBuilder rev = new StringBuilder();

        for(int i = s.length()-1 ; i >= 0; i--) {
            rev.append(s.charAt(i));
        }
        return rev.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPrefix("a*b+c/d"));
    }
}
