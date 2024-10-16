import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i;
    }   
}
