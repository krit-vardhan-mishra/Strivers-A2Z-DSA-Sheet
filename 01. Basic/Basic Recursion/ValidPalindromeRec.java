
public class ValidPalindromeRec {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        char[] arr = s.toCharArray();
        return helper(arr, 0, arr.length-1);
    }

    public static boolean helper(char[] arr, int start, int end) {
        if(start >= end) return true;
        if(arr[start] != arr[end]) return false;
        return helper(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
