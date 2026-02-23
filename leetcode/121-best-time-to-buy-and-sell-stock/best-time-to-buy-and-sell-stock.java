class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
          int profit=prices[i]-minBuyPrice;
          maxProfit=maxProfit<profit?profit:maxProfit;
          minBuyPrice=minBuyPrice>prices[i]?prices[i]:minBuyPrice;
        }
        return maxProfit;
    }
}