package General_Problems;

public class StockBuySellPatterns {

    /*
     * ============================================================
     * METHOD 1: SINGLE TRANSACTION ALLOWED
     * ============================================================
     * You can buy ONCE and sell ONCE
     * Buy must happen before sell
     *
     * PATTERN:
     * Greedy + Prefix Minimum
     *
     * IDEA IN PLAIN WORDS:
     * - Keep track of the lowest price so far
     * - At each day, assume "what if I sell today?"
     * - Maximize the profit
     *
     * TIME: O(n)
     * SPACE: O(1)
     */
    public static void singleTransactionMaxProfit() {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int lowestPrice = prices[0];   // minimum price seen so far
        int maxProfit = 0;             // best profit till now

        for (int i = 1; i < prices.length; i++) {

            // If current price is lower, update buying price
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } 
            // Otherwise, calculate profit if sold today
            else {
                int profitIfSoldToday = prices[i] - lowestPrice;
                maxProfit = Math.max(maxProfit, profitIfSoldToday);
            }
        }

        System.out.println("Single Transaction Max Profit = " + maxProfit);
    }

    /*
     * ============================================================
     * METHOD 2: MULTIPLE TRANSACTIONS ALLOWED
     * ============================================================
     * You can buy and sell MANY times
     * But must sell before buying again
     *
     * PATTERN:
     * Greedy + Local Profit Accumulation
     *
     * IDEA IN PLAIN WORDS:
     * - Whenever price goes UP from yesterday → take profit
     * - Add all positive differences
     *
     * TIME: O(n)
     * SPACE: O(1)
     */
    public static void multipleTransactionMaxProfit() {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            // If today is higher than yesterday, take profit
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        System.out.println("Multiple Transaction Total Profit = " + totalProfit);
    }

    // MAIN METHOD TO RUN BOTH (optional)
    public static void main(String[] args) {
        singleTransactionMaxProfit();
        multipleTransactionMaxProfit();
    }
}
