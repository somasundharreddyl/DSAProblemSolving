class Solution {
    public int calculate(String s) {
        Stack<Character> operators=new Stack<>();
        Stack<Integer> operands=new Stack<>();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int num=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                  num=num*10+(s.charAt(i)-'0');  
                  i++;
                }
                operands.push(num);
                i--;
            }else if(s.charAt(i)>='(' || s.charAt(i)>=')' || s.charAt(i)>='+' || s.charAt(i)>='-'
            || s.charAt(i)>='*' || s.charAt(i)>='/' || s.charAt(i)>='^'){
                while(operators.size()>0 && precedence(operators.peek())>=precedence(s.charAt(i))){
                  int num2=operands.pop();
                  int num1=operands.pop();
                  char ops=operators.pop();
                  int res=calc(num1,num2,ops);
                  operands.push(res);
                }
                operators.push(s.charAt(i));
            }
            i++;
        }
        while(operators.size()>0){
            int num2=operands.pop();
                  int num1=operands.pop();
                  char ops=operators.pop();
                  int res=calc(num1,num2,ops);
                  operands.push(res);
        }
        return operands.pop();
    }

    public int calc(int n1, int n2, char op){
        if(op=='+'){
            return n1+n2;
        }else if(op=='-'){
            return n1-n2;
        }else if(op=='*'){
            return n1*n2;
        }else{
            return n1/n2;
        }
    }

    public int precedence(char ch){
        if(ch=='^'){
            return 2;
        }else if(ch=='*' || ch=='/'){
            return 1;
        }else if(ch=='('){
            return -1;
        }else{
            return 0;
        }
    }
}