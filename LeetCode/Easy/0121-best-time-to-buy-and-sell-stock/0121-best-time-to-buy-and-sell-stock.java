class Solution {
  public int maxProfit(int[] prices) {
    int buyPrice = Integer.MAX_VALUE, maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      buyPrice = Math.min(buyPrice, prices[i]);
      maxProfit = Math.max(prices[i] - buyPrice, maxProfit);
    }
    return maxProfit;
  }
}