class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int bp=prices[i-1];
            int sp=prices[i];
            int profit=sp-bp;
            if(profit>0){
                maxProfit+=profit;
            }
        }
        return maxProfit;
    }
}