public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxVal = 0;
        int minVal = prices[0];

        for(int i = 1; i < prices.length; i++) {
            if(minVal > prices[i]) {
                minVal = prices[i];
            } else if(prices[i] - minVal > maxVal) {
                maxVal = prices[i] - minVal;
            }
        }
        return maxVal;
    }
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(maxProfit(arr));
    }
}
