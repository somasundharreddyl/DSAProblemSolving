class Solution {
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        int k=1;
        for(int i=0;i<nums.length;i++){
            arr[k]=nums[i];
            k++;
        }
        arr[arr.length-1]=1;
        int start=0,end=arr.length;
        int[][] dp=new int[arr.length][arr.length];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
       return burstBallons(arr,start,end-1,dp);
    }
    public int burstBallons(int[] arr,int start,int end,int[][] dp){
             if(start+1>=end){
                return 0;
             }
             if(dp[start][end]!=-1){return dp[start][end];}
             int ans=Integer.MIN_VALUE;
             for(int i=start+1;i<end;i++){
                int left=burstBallons(arr,start,i,dp);
                int right=burstBallons(arr,i,end,dp);
                ans=Math.max(ans,left+right+arr[start]*arr[end]*arr[i]); 
             }
             dp[start][end]=ans;
             return ans;

    }
}