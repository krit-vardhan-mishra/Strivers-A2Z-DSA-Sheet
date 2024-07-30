public class CountDigits {
    public static int evenlyDivides(int N) {
        int count = 0;
        int temp = N;
        while (temp > 0) {
            int ld = temp % 10;
            if(ld != 0 && N % ld == 0){
                count++;
            }
            temp /= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(evenlyDivides(12));
        System.out.println(evenlyDivides(22074));
        System.out.println(evenlyDivides(23));
    }
}
