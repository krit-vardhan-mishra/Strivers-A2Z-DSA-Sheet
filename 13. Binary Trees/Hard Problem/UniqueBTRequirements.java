
public class UniqueBTRequirements {
    public static boolean isPossible(int a, int b) {
        if ((a == 2 || b == 2) && a != b) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(1, 3) ? 1 : 0);
        System.out.println(isPossible(1, 2) ? 1 : 0);
    }
}
