import java.util.Stack;

public class PrefixToInfix {

    public static String preToInfix(String pre_exp) {
        Stack<String> stack = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {

            char ch = pre_exp.charAt(i);
            if (isOperator(ch)) {
                String opt1 = stack.pop();
                String opt2 = stack.pop();

                String temp = "(" + opt1 + ch + opt2 + ")";
                stack.push(temp);
            } else {
                stack.push(ch+"");
            }
        }

        return stack.isEmpty() ? "" : stack.pop();
    }

    public static boolean isOperator(char ch) {
        switch (ch) {
            case '+': return true;
            case '-': return true;
            case '*': return true;
            case '/': return true;
            case '^': return true;
            case '%': return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(preToInfix("-A/BC-/AKL"));
    }
}
