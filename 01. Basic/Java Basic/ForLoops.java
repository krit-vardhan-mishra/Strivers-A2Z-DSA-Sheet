public class ForLoops {

    public static void printFib(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a+" ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        printFib(6);
    }
}
