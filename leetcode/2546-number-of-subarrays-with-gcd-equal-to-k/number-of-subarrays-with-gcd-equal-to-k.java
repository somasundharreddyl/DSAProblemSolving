class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count=0;
        for(int start=0;start<nums.length;start++){
            int gcd=0;
            for(int end=start;end<nums.length;end++){
                gcd=gcd(nums[end],gcd);
                if(gcd<k){break;}
                if(gcd==k){
                    count++;
                }
            }
        }
        return count;
    }
    public int gcd(int a, int b){
        if(a==0){return b;}
        return gcd(b%a,a);
    }
}