class Solution {
    public int mySqrt(int x) {
        long x1=x;
       long start=1,end=x;
       while(start<=end){
       long mid=start+(end-start)/2;
       if(mid*mid==x1){
           return (int)mid;
       }else if(mid*mid>x1){
           end=mid-1;
       }else{
           start=mid+1;
       }
       } 
       return (int)end;
    }
}