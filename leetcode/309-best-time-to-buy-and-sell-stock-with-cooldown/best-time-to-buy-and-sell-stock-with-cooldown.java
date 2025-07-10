class Solution {
    public int maxProfit(int[] prices) {
        int buyingProfit=prices[0]*-1;
        int sellingProfit=0;
        int cooldownProfit=0;
        for(int i=1;i<prices.length;i++){
            int newBuyingProfit=Math.max(buyingProfit,cooldownProfit-prices[i]);
            int newSellingProfit=Math.max(sellingProfit,prices[i]+buyingProfit);
            int newCooldownProfit=Math.max(sellingProfit,cooldownProfit);
            buyingProfit=newBuyingProfit;
            sellingProfit=newSellingProfit;
            cooldownProfit=newCooldownProfit;
        }
        return sellingProfit;
    }
}