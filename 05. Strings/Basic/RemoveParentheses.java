

public class RemoveParentheses {

    public static String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if(ch == '(') {
                if(count > 0) {
                    res.append(ch);
                }
                count++;
            } else {
                count--;
                if(count > 0) {
                    res.append(ch);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()"));
    }
}
