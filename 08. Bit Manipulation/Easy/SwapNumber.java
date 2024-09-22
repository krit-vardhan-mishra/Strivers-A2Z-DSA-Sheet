import java.util.ArrayList;
import java.util.List;

public class SwapNumber {

    // 9 13
    public static List<Integer> get(int a, int b) {
        List<Integer> result = new ArrayList<>();
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        result.add(a);
        result.add(b);
        return result;
    }

    public static void main(String[] args) {
        int a = 13;
        int b = 9;
        System.out.println("a : "+a+" b : "+b);
        System.out.println(get(a, b));        
    }
}
