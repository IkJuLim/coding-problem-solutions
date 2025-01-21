class Solution {
  public int maxProfit(int[] prices) {
    int ret = 0, buyPrice = 0;
    boolean isHolding = false;

    for (int i = 0; i < prices.length-1; i++) {
      if (isHolding) {
        if (prices[i + 1] < prices[i]) {
          ret += prices[i] - buyPrice;
          isHolding = false;
        }
      } else {
        if (prices[i + 1] > prices[i]) {
          buyPrice = prices[i];
          isHolding = true;
        }
      }
    }
    if (isHolding) {
      ret += prices[prices.length - 1] - buyPrice;
    }

    return ret;
  }
}