public class Q2_BestTimeToBuySellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0]; // ab tak ka minimum price
        int maxProfit = 0;        // ab tak ka max profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // naya minimum mila
            }
            int profit = price - minPrice; // aaj bechne ka profit
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
