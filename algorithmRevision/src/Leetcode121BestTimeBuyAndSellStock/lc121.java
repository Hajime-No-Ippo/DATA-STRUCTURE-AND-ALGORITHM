package Leetcode121BestTimeBuyAndSellStock;

public class lc121 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        if(prices.length < 2){
            return 0;
        }

        for (int i = 1; i < prices.length; i++) {
            int curPrice = prices[i];
            int curProfit = curPrice - minPrice;
            if(curProfit > maxProfit){
                maxProfit = curProfit;
            }
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
