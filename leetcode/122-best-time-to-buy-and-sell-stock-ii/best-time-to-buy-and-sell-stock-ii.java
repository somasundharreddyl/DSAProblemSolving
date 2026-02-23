class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit=0;
        int[] profits = new int[prices.length-1];
        for(int i=1;i<prices.length;i++){
            profits[i-1]=prices[i]-prices[i-1];
        }
        for(int i=0;i<profits.length;i++){
            if(profits[i]>0){
                totalProfit+=profits[i];
            }
        }
        return totalProfit;
    }
}