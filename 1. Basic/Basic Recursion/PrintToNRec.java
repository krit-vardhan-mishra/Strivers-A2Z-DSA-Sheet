public class PrintToNRec {
    public static void printNos(int N) {
        if(N == 1) {
            System.out.print(N+" ");
            return;
        }
        printNos(N-1);
        System.out.print(N+" ");
    }
    public static void main(String[] args) {
        printNos(10);
        System.out.println();
        printNos(5);
    }
}
