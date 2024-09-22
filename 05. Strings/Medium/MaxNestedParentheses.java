public class MaxNestedParentheses {

    public static int maxDepth(String s) {
        int maxParentheses = 0;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if(ch == '(') {
                ++count;
            } 
            if(ch == ')') {
                --count;
            }
            maxParentheses = Math.max(maxParentheses, count);
        }

        return maxParentheses;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1)"));
        System.out.println(maxDepth("(1)+((2))+(((3))"));
        System.out.println(maxDepth("()(())((()()))"));
    }
}
