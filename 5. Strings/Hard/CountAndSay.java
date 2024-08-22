public class CountAndSay {
    public static String countAndSay(int n) {
        String ans = "1";

        while (--n > 0) {
            StringBuilder next = new StringBuilder();

            for (int i=0; i < ans.length();) {
                int count = 0;
                char ch = ans.charAt(i);

                while (i < ans.length() && ans.charAt(i) == ch) {
                    i++;
                    count++;
                }
                next.append(count).append(ch);
            }
            ans = next.toString();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(1));
    }
}
