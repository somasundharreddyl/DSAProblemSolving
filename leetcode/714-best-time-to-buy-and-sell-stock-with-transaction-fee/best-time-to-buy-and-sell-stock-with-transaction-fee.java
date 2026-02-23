class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=-prices[0];
        int sell=0;
        for(int i=1;i<prices.length;i++){
            int tBuy=Math.max(buy,sell-prices[i]);
            int tSell=Math.max(sell,prices[i]-fee+buy);
            buy=tBuy;
            sell=tSell;
        }
        return sell;
    }
}