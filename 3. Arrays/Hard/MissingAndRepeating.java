public class MissingAndRepeating {

    public static int[] findTwoElement(int[] arr, int n) {
        int repeating = 0, missing = 0;
        long totalSum = (long) n*(n+1)/2, totalSumSqr = (long) n*(n+1)*(2*n+1)/6;
        long arrSum = 0, arrSumSqr = 0;
        
        for(int num : arr) {
            arrSum += num;
            arrSumSqr += (long) num * num;
        }
        
        long sumDif = arrSum - totalSum;
        long sumDifSqr = arrSumSqr - totalSumSqr;
        
        sumDifSqr = sumDifSqr/sumDif;
        
        repeating = (int) (sumDif + sumDifSqr)/2;
        missing = (int) (repeating - sumDif);
        
        return new int[]{repeating, missing};
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3};
        int[] res = findTwoElement(arr, arr.length);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
