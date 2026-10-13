class Solution {
    public int calculate(String s) {
        Stack<Integer> operands=new Stack<>();
        Stack<Character> operators=new Stack<>();
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            int num=0;
            while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
               num=(num*10)+(s.charAt(i)-'0');
               i++;
            }
          operands.push(num);
          i--;
        }else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
           if(!operators.isEmpty() && precedence(operators.peek())>=precedence(s.charAt(i))){
            while(!operators.isEmpty() && precedence(operators.peek())>=precedence(s.charAt(i))){
            int num2=operands.pop();
            int num1=operands.pop();
            int res=calc(num1,num2,operators.pop());
            operands.push(res);
           }
           operators.push(s.charAt(i));
           }else{
            operators.push(s.charAt(i));
           }
        }
       }
       while(!operators.isEmpty()){
        int num2=operands.pop();
        int num1=operands.pop();
        int res=calc(num1,num2,operators.pop());
        operands.push(res);
       }
       return operands.peek(); 
    }
    public int precedence(char ch){
        if(ch=='+' || ch=='-'){
            return 0;
        }else if(ch=='*' || ch=='/'){
            return 1;
        }else{
            return 2;
        }
    }
    public int calc(int num1,int num2,char ch){
        if(ch=='+'){
         return num1+num2;
        }else if(ch=='-'){
         return num1-num2;
        }else if(ch=='*'){
         return num1*num2;
        }else if(ch=='/'){
         return num1/num2;
        }else{
            return 0;
        }
    }
}