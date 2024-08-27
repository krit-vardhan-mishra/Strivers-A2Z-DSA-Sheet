public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        boolean[] arr = new boolean[26];

        for (char ch : a.toCharArray()) arr[ch-'a'] = true;
        for (char ch : b.toCharArray()) {
            if (!arr[ch-'a']) return -1;
        }

        int count = b.length() / a.length();
        StringBuilder result = new StringBuilder(a.repeat(count));

        for (int i = 0; i < 3; i++) {
            if (result.indexOf(b) >= 0) return count + i;
            result.append(a);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("a", "aa"));
    }
}
