
public class MinBitFlips {
    public static int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(minBitFlips(3, 4));
    }
}
