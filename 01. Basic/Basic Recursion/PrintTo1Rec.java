public class PrintTo1Rec {
    public static void printNos(int N) {
        if(N == 1) {
            System.out.print(N+" ");
            return;
        }
        System.out.print(N+" ");
        printNos(N-1);
    }
    public static void main(String[] args) {
        printNos(10);
        System.out.println();
        printNos(5);
    }
}
