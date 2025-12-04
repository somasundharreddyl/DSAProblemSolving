class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count=0;
       for(int i=0;i<nums.length;i++){
        int gcd=0;
        for(int j=i;j<nums.length;j++){
          gcd=gcd(gcd,nums[j]);
          if(gcd<k){
            break;
          }
          if(gcd==k){
            count++;
          }
        }
       }
       return count;
    }
    public int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}