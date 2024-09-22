
public class TwoSingleOcc {
    public int[] twoOddNum(int Arr[], int N) {
        int xor = 0;
        for (int i : Arr) {
            xor ^= i;
        }

        int temp = xor & -xor;
        int n1 = 0, n2 = 0;
        for (int i : Arr) {
            if ((i&temp) == 0) n1 ^= i;
            else n2 ^= i;
        }

        if (n1>n2) return new int[]{n1, n2};
        else return new int[]{n2, n1};
    }    
}
