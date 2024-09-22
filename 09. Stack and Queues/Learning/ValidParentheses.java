import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s.length() == 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if ((s.charAt(i) == ')' && top != '(') || (s.charAt(i) == ']' && top != '[') || (s.charAt(i) == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));
        System.out.println(isValid("{[]}"));
    }
}
