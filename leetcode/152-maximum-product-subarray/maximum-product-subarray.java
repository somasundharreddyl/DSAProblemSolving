class Solution {
    public int maxProduct(int[] nums) {
        int prefixProd=1,max1=Integer.MIN_VALUE,suffixProd=1,max2=Integer.MIN_VALUE;
        
        //Prefix
         for(int i=0;i<nums.length;i++){
             if(prefixProd==0){prefixProd=1;}
             prefixProd*=nums[i];
            max1=max1>prefixProd?max1:prefixProd;
         }

         //Suffix
         for(int i=nums.length-1;i>=0;i--){
             if(suffixProd==0){suffixProd=1;}
             suffixProd*=nums[i];
            max2=max2>suffixProd?max2:suffixProd;
         }

         return max1>max2?max1:max2;
    }
}