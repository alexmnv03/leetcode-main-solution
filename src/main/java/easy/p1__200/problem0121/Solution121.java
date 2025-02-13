package easy.p1__200.problem0121;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Solution121 {

    public static int maxProfitTest(int[] prices) {
        return maxProfit(prices);
    }

    public static void main(String[] args) {
        int[] array01 = new int[]{7, 1, 5, 3, 6, 4};
        int[] array02 = new int[]{7, 6, 4, 3, 1};

        System.out.println(maxProfit(array01));
        System.out.println(maxProfit(array02));

        assertEquals(5, maxProfit(array01));
        assertEquals(0, maxProfit(array02));

        assertEquals(5, maxProfitTest(array01));
        assertEquals(0, maxProfitTest(array02));

    }

    public static int maxProfit(int[] prices) {
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
