public class SetRightmostUnsetBit {
    public static int setBit(int n) {
        return n | (n+1);
    }

    public static void main(String[] args) {
        System.out.println(setBit(6));
        System.out.println(setBit(15));
    }
}
