import java.util.Stack;

public class PostfixToPrefix {
    public static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);

            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                stack.push(ch+"");
            } else {
                String one = stack.pop();
                String two = stack.pop();

                String temp = ch + two + one;
                stack.push(temp);
            }
        }

        return stack.isEmpty() ? "" : stack.pop();
    }
    public static void main(String[] args) {
        System.out.println(postToPre("ABC/-AK/L-*"));
    }
}
