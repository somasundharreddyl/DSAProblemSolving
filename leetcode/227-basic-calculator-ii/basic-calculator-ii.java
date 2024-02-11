class Solution {
    public int calculate(String s) {
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num=0;
                while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9')){
                    num=num*10+(s.charAt(i)-'0');
                    i++;
                }
                operand.push(num);
                i--;
            }
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='*' || s.charAt(i)=='/'){
                while(operator.size()>0 && precedence(s.charAt(i))<=precedence(operator.peek())){
                   char c=operator.pop();
                   int val2=operand.pop();
                   int val1=operand.pop();
                   int res=calc(val1,val2,c);
                   operand.push(res);
                }
                operator.push(s.charAt(i));
            }
            i++;
        }
        while(operator.size()>0){
             char c=operator.pop();
                   int val2=operand.pop();
                   int val1=operand.pop();
                   int res=calc(val1,val2,c);
                   operand.push(res);
        }
        return operand.pop();
    }

    private int precedence(char c){
        if(c=='*' || c=='/'){
            return 1;
        }else if(c=='+' || c=='-'){
            return 0;
        }
        return -1;
    }

    private int calc(int num1,int num2, char ch){
        if(ch=='*'){
            return num1*num2;
        }else if(ch=='/'){
            return num1/num2;
        }else if(ch=='+'){
            return num1+num2;
        }else if(ch=='-'){
            return num1-num2;
        }
        return -1;
    }
}