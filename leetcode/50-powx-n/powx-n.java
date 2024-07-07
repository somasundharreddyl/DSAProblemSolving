class Solution {

    public double power(double x, long n1){
    
        if(n1==1){
            return x;
        }
        if(n1==0){
            return 1;
        }
        double temp=myPow(x, (int)(n1 / 2L));
         if(n1%2==1){
           return x*temp*temp; 
        }else{
        return temp*temp;
        }
        
    }

    public double myPow(double x, int n) {
        long n1=n;
        if(n1<0){
           n1=n1*(-1);
           x=1/x;
        }
        return power(x,n1);
        }
    }
