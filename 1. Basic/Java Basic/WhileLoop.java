public class WhileLoop {

    public static void printTable(int n) {
        int mul = 10;
        while (mul > 0) {
            System.out.print(n*mul);
            mul--;
        }
    }

    public static void main(String[] args) {
        printTable(1);
    }
}
