class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                arr[i][j]=0;
                }else{
                arr[i][j]=1;
                }
            }
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            Stack<Integer> stack=new Stack<>();
            for(int j=0;j<n;j++){
                if(i==0){
                  if(stack.isEmpty()){
                    stack.push(j);
                    continue;
                  }
                  while(stack.size()>0 && arr[i][stack.peek()]>=arr[i][j]){
                    int h=stack.pop();
                    int x2=j;
                    int x1=-1;
                    if(stack.size()>0){
                     x1=stack.peek();
                    }
                    int area=((x2-1)-(x1+1)+1)*arr[i][h];
                    maxArea=Math.max(area,maxArea);
                  }
                  stack.push(j);  
                }else{
                  if (matrix[i][j] == '1') {
                      arr[i][j] += arr[i-1][j];
                    } else {
                        arr[i][j] = 0;
                     }  
                  if(stack.isEmpty()){
                    stack.push(j);
                    continue;
                  }
                  while(stack.size()>0 && arr[i][stack.peek()]>=arr[i][j]){
                    int h=stack.pop();
                    int x2=j;
                    int x1=-1;
                    if(stack.size()>0){
                     x1=stack.peek();
                    }
                    int area=((x2-1)-(x1+1)+1)*arr[i][h];
                    maxArea=Math.max(area,maxArea);
                  }
                  stack.push(j);
                }
            }

            while(stack.size()>0){
                    int h=stack.pop();
                    int x2=n;
                    int x1=-1;
                    if(stack.size()>0){
                     x1=stack.peek();
                    }
                    int area=((x2-1)-(x1+1)+1)*arr[i][h];
                    maxArea=Math.max(area,maxArea);
                }
        }
        return maxArea;
    }
}