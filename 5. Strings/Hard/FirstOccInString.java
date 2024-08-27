public class FirstOccInString {
    public static int strStr(String haystack, String neddle) {
        if (neddle.length() > haystack.length()) return -1;
        if (neddle.length() == 0) return -1;
        
        for (int i=0; i <= haystack.length() - neddle.length(); i++) {
            int j;
            for (j = 0; j < neddle.length(); j++) {
                if (haystack.charAt(i + j) != neddle.charAt(j)) {
                    break;
                }
            }
            if (j == neddle.length()) return i;
        }

        return -1;
        // return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("Manav", "nav"));
    }
}
