public class CheckPalindrome {
    public static boolean isPalindrome(int num) {
        if (num < 0) return false;
        if (num == 0) return true;
        int temp = num;
        int rev = 0;

        while (temp != 0) {
            int ld = temp % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7)) {
                return false; 
            }
            rev = (rev*10) + ld;
            temp /= 10;
        }

        return rev == num;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
