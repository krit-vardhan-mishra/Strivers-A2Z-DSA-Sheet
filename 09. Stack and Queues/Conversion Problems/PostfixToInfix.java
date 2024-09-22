import java.util.Stack;

public class PostfixToInfix {

    public static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                stack.push(Character.toString(ch));
            } else {
                String opt1 = stack.pop();
                String opt2 = stack.pop();

                String temp = "(" + opt2 + ch + opt1 + ")";
                stack.push(temp);
            }
        }

        return stack.isEmpty() ? "" : stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(postToInfix("ab*c+"));
    }
}
