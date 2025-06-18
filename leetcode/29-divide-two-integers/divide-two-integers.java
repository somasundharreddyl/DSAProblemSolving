class Solution {
    public int divide(int dividend, int divisor) {
        int sign=1;
        long sum=0,q=0;
        if(dividend<0){sign=sign*-1;}
        if(divisor<0){sign=sign*-1;}
        long a=dividend;
        long b=divisor;
        a=(Math.abs(a));
        b=(Math.abs(b));
        for(int i=31;i>=0;i--){
           if(sum+(b<<i)<=a){
            sum=sum+(b<<i);
            q=q+((long)1<<i);
           } 
        }
        if(sign<0){
            q=-q;
        }
        if(q>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(q<Integer.MIN_VALUE){
           return Integer.MIN_VALUE;
        }
        return (int)q;
    }
}
