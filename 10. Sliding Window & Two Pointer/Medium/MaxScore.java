public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int count = 0;
        int sum = 0;

        for (int cards : cardPoints) {
            sum += cards;
        }

        if (k == cardPoints.length) {
            return sum;
        }

        int temp = 0;

        for (int i=0; i<cardPoints.length-k; i++) {
            temp += cardPoints[i];
        }

        count = sum - temp;

        for (int i = 0; i < k; i++) {
            temp -= cardPoints[i];
            temp += cardPoints[i + cardPoints.length - k];
            count = Math.max(count, sum - temp);
        }

        return count;
    }    
}
