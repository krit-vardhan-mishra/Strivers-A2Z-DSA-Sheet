
public class XORLToR {
    public static int findXOR(int l, int r) {
        return helper(l-1) ^ helper(r);
    }

    public static int helper(int n) {
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n+1;
        if (n % 4 == 3) return 0;
        if (n % 4 == 0) return n;
        return -1;
    }
}
