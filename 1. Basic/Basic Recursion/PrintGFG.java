
public class PrintGFG {
    public static void printGfg(int n) {
        if(n == 1) {
            System.out.print("GFG ");
            return;
        }
        printGfg(n-1);
        System.out.print("GFG ");
    }

    public static void main(String[] args) {
        printGfg(5);
    }
    
}