import java.util.ArrayList;
import java.util.List;

// Given an integer, K. Generate all binary strings of size k without consecutive 1’s.
public class GenerateBinaryStringsOfSizeK {

    public static List<String> generateBinaryStrings(int n) {
        if(n <= 0) return new ArrayList<String>();

        char[] ch = new char[n];

        ch[0] = '0';
        List<String> r = generate(n, ch, 1);
        ch[0] = '1';
        List<String> l = generate(n, ch, 1);

        r.addAll(l);
        return r;
    }

    public static List<String> generate(int n, char[] arr, int idx) {
        if(idx == n) {
            List<String> a = new ArrayList<>();
            a.add(new String(arr));
            return a;
        }

        List<String> ans = new ArrayList<>();
        if(arr[idx - 1] == '0') {
            arr[idx] = '0';
            ans.addAll(generate(n, arr, idx+1));
            arr[idx] = '1';
            ans.addAll(generate(n, arr, idx+1));
        }

        if(arr[idx-1] == '1') {
            arr[idx] = '0';
            ans.addAll(generate(n, arr, idx+1));
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> lst = generateBinaryStrings(3);
        System.out.println(lst);
    }
}
