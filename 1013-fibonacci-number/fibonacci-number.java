class Solution {
    public int fib(int n) {
      if(n==0||n==1) {
          return n;
      } 
        int i=2,n1=0,n2=1;
        
        while(i<=n){
            
            int temp=n1;
            n1=n2;
            n2=temp+n2;
            
            i++;
        }
        return n2;
    }
}