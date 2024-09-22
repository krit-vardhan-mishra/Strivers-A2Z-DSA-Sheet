public class LargestOddNum {

    // Hint : Just start checking from last
    public static String largestOddNumber(String s) {
        if((s.charAt(s.length()-1) - '0') % 2 != 0) return s;

        for (int i = s.length()-2; i >= 0; i--) {
            int num = s.charAt(i)-'0';
            if(num % 2 != 0) return s.substring(0, i+1);
        }

        return "";
    }
    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
    }
}
