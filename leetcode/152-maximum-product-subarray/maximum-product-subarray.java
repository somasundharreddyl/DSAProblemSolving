class Solution {
    public int maxProduct(int[] nums) {
       int prefixMaxProd=nums[0],overAllPrefixMaxProd=nums[0],suffixMaxProd=nums[nums.length-1],overAllSuffixMaxProd=nums[nums.length-1];

       for(int i=1;i<nums.length;i++){
           if(prefixMaxProd==0){prefixMaxProd=nums[i];}
          else{ prefixMaxProd*=nums[i];}
            overAllPrefixMaxProd=overAllPrefixMaxProd>prefixMaxProd?overAllPrefixMaxProd:prefixMaxProd;
       }

        for(int i=nums.length-2;i>=0;i--){
            if(suffixMaxProd==0){suffixMaxProd=nums[i];}
          else{ suffixMaxProd*=nums[i];}
            overAllSuffixMaxProd=overAllSuffixMaxProd>suffixMaxProd?overAllSuffixMaxProd:suffixMaxProd;
       }

       return overAllPrefixMaxProd>overAllSuffixMaxProd?overAllPrefixMaxProd:overAllSuffixMaxProd;
    }
}