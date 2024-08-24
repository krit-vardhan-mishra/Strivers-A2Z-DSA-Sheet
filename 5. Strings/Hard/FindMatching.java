public class FindMatching {
    public static int findMatching(String text, String pat) {
        int result = text.indexOf(pat);

        return result != -1 ? result : -1;
    }

    public static void main(String[] args) {
        System.out.println(findMatching("gffgfg", "gfg"));
        System.out.println(findMatching("gffggg","gfg"));
    }
}
