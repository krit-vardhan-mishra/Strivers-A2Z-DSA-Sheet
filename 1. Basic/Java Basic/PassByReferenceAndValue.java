import java.util.Arrays;

public class PassByReferenceAndValue {
    public static int[] passedBy(int a, int b) {
        return new int[]{a+1, b+2};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(passedBy(1,2)));
    }
}
