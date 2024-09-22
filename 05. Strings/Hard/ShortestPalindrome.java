public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        String temp = new StringBuilder(s).reverse().toString();

        for (int i=0; i<temp.length(); i++) {
            if (s.startsWith(temp.substring(i))) return temp.substring(0, i) + s;
        }

        return temp + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }
}
