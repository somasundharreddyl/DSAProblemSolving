class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer> operands=new Stack<>();
        Stack<String> operators=new Stack<>();
        for(int i=0;i<n;i++){ 
          if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                 String op=tokens[i];
                 int val2=operands.pop();
                 int val1=operands.pop();
                 int val=calc(val1,val2,op);
                 operands.push(val);  
          }else{
            String str=tokens[i];
            int k=0,num=0,sign=1;
            while(k<str.length()){
                if(k==0 && str.charAt(k)=='-'){
                   sign=sign*-1;
                   k++;
                   continue;
                }
                num=(num*10)+(str.charAt(k)-'0');
                k++;
            }
            operands.push(num*sign);
          }
        }
        return operands.pop();
    }
    public int calc(int v1,int v2,String s){
         if(s.equals("+")){
          return v1+v2;
         }else if(s.equals("-")){
          return v1-v2;
         }else if(s.equals("*")){
          return v1*v2;
         }else {
          return v1/v2;
         }
    }

    public int precedence(String s){
        if(s.equals("*") || s.equals("/")){
            return 1;
        }else{
            return 0;
        }
    }
}