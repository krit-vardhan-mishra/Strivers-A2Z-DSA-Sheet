public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        goal += goal;
        
        return goal.contains(s);
    }
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }
}
