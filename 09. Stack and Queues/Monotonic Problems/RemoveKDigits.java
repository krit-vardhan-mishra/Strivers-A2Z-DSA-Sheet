import java.util.Stack;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && (stack.peek() -'0') > (ch - '0')) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res.reverse();
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        System.out.println(removeKdigits(num, 3));
    }
}
