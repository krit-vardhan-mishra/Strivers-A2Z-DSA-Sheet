public class KthBitInSet {
    static boolean checkKthBit(int n, int k) {
        return (n & (1 << k)) != 0;
    }

    public static void main(String[] args) {
        System.out.println(checkKthBit(4, 0));
        System.out.println(checkKthBit(4, 2));
    }
}
