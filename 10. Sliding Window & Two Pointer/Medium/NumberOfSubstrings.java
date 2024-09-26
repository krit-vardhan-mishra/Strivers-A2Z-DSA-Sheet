import java.util.Arrays;

public class NumberOfSubstrings {
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] check = new int[3];
        Arrays.fill(check, -1);

        for (int i=0; i<s.length(); i++) {
            check[s.charAt(i)-'a'] = i;
            if (check[0] != -1 &&  check[1] != -1 && check[2] != -1) {
                count += Math.min(check[0], Math.min(check[1], check[2]))+1;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
    }
}
