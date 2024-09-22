public class CountTotalSetBits {
    public static int countSetBits(int n) {
        if (n <= 1) return n;
        
        int x = hummingWeight(n);
        return (x * (int)Math.pow(2, (x-1))) + (n - (int)Math.pow(2, x)+1) + countSetBits(n-(int)Math.pow(2,x));
    }
    
    public static int hummingWeight(int n) {
        int count = 0;
        while ((1 << count) <= n) {
            count++;
        }
        return count-1;
    }
    
    public static void main(String[] args) {
        System.out.println(countSetBits(4));
        System.out.println(countSetBits(17));
    }
}
