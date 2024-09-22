public class OddOrEven {
    static String oddEven(int n) {
        return (n & 1) == 1 ? "odd" : "even";
    }

    public static void main(String[] args) {
        System.out.println(oddEven(15));
        System.out.println(oddEven(44));
    }
}
