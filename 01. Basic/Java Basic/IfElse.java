public class IfElse {
    public static void main(String[] args) {
        System.out.println(compareNM(4, 8));
    }

    private static String compareNM(int n, int m) {
        if(n < m) return "lesser";
        else if(n == m) return "equal";
        else return "greater";
    }
}
