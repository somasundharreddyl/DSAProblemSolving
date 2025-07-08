class Solution {
    public int maxProfit(int[] prices) {
        int bp=prices[0];
        int maxProfit=0;
       for(int i=1;i<prices.length;i++){
        int sp=prices[i];
        int profit=sp-bp;
        if(profit>maxProfit){
            maxProfit=profit;
        }
        bp=Math.min(bp,sp);
       }
       return maxProfit;
    }
}