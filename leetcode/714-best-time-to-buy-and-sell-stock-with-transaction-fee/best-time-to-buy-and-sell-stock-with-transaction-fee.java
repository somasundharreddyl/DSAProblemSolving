class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyingProfit=prices[0]*-1;
        int sellingProfit=0;
        for(int i=1;i<prices.length;i++){
            int newBuyingProfit=Math.max(buyingProfit,sellingProfit-prices[i]);
            int newSellingProfit=Math.max(sellingProfit,prices[i]+buyingProfit-fee);
            buyingProfit=newBuyingProfit;
            sellingProfit=newSellingProfit;
        }
        return sellingProfit;
    }
}