class Solution {
    public int divide(int dividend, int divisor) {
        long k=divisor,n=dividend;
        int sign=1;
        if(k<0){sign*=-1;}
        if(n<0){sign*=-1;}
        k=Math.abs(k);
        n=Math.abs(n);
        long ans=0,sum=0;
    for(int i=31;i>=0;i--){
        if((sum+(k<<i))<=n){
            ans+=((long)1<<i);
            sum+=(k<<i);
        }
    }
    if(sign<0){ans*=sign;}
    if(ans>Integer.MAX_VALUE){
        ans=Integer.MAX_VALUE;
    }
    if(ans<Integer.MIN_VALUE){
        ans=Integer.MIN_VALUE;
    }
    return (int)ans;    
    }
}