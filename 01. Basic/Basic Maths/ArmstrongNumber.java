public class ArmstrongNumber {
    public static boolean armstrongNumber(int num) {
        int temp = num;
        int temp2 = num;
        int armNum = 0;
        int totalCount = 0;
        while(temp2>0) {
            totalCount++;
            temp2 /= 10;
        }
        while(temp > 0) {
            int ld = temp % 10;
            armNum += Math.pow(ld,totalCount);
            temp /= 10;
        }
        return num == armNum;
    }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(123));
    }
}
