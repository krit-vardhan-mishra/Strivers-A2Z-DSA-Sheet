import java.util.Stack;

public class PrefixToPostfix {

    public static String preToPost(String pre_exp) {
        Stack<String> operands = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            char ch = pre_exp.charAt(i);

            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                operands.push(Character.toString(ch));
            } else {
                String one = operands.pop();
                String two = operands.pop();

                String temp = one+two+ch;
                operands.push(temp);
            }
        }

        return operands.isEmpty() ? "" : operands.pop();
    }

    public static void main(String[] args) {
        System.out.println(preToPost("-A/BC-/AKL"));
    }
}
