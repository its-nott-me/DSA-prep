/*
    Problem: Best Time to Buy and Sell Stock

    Description:
    Given an array prices where prices[i] is the price of a stock on day i,
    find the maximum profit you can achieve by buying on one day and selling
    on another later day.

    Approach: Single Pass (Greedy)

    Time Complexity: O(n)
    Space Complexity: O(1)

    Key Idea:
    - Track the minimum price seen so far (buy point)
    - At each day, compute profit if sold today
    - Update maximum profit accordingly
    - Always ensure buy happens before sell

    Notes:
    - Only one transaction allowed
    - If no profit possible, return 0
*/

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int buy = 0;
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[buy]){
                buy = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[buy]);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args){
        BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(sol.maxProfit(prices)); // Output: 5
    }
}