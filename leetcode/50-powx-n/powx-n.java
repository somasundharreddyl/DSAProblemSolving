class Solution {
     public double myPow(double x, int n) {
         long n1=n;
        if(n1<0){
           n1=n1*(-1);
           x=1/x;
        }
        return pow(x,n1);
}
    public double pow(double x, long n){
       if(n==1){
            return x;
        }
        if(n==0){
            return 1;
        }
        double temp=pow(x,n/2);
        if(n%2==0){
            return temp*temp;
        }else{
            return x*temp*temp;
        }
    }
}