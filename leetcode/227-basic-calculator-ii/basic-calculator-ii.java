class Solution {
    public int calculate(String s) {
        Stack<Integer> operands=new Stack<>();
        Stack<Character> operators=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    int a=s.charAt(i)-'0';
                    num=(num*10)+a;
                    i++;
                }
                operands.push(num);
                i--;
            }else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
                
                  while(operators.size()>0 && precedence(s.charAt(i))<=precedence(operators.peek())){
                    int val2=operands.pop();
                    int val1=operands.pop();
                    char c=operators.pop();
                    int cal=calculate(val1,val2,c);
                    operands.push(cal);
                  }
            
                operators.push(s.charAt(i));
            }
        }
        while(operators.size()>0){
                    int val2=operands.pop();
                    int val1=operands.pop();
                    char c=operators.pop();
                    int cal=calculate(val1,val2,c);
                    operands.push(cal);
        }
        return operands.pop();
    }
    public int precedence(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }else if(ch=='*' || ch=='/'){
            return 2;
        }else{
            return 3;
        }
    }
    public int calculate(int a,int b,char c){
        if(c=='+'){
            return a+b;
        }else if(c=='-'){
            return a-b;
        }else if(c=='*'){
            return a*b;
        }else{
            return a/b;
        }
    }
}
