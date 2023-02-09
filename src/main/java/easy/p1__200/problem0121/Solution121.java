package easy.p1__200.problem0121;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minPrices = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            // Находим минимальную цену
            if (prices[i] < minPrices){
                minPrices = prices[i];
            }
            // в этом же цикле находим максимальную разность
            if ((prices[i] - minPrices) > maxDiff) {
                maxDiff = prices[i] - minPrices;
            }
        }
        return maxDiff;
    }

}
