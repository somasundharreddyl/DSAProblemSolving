class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] arr=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
               if(i==0){
                if(matrix[i][j]=='1'){
                   arr[i][j]=1;
                }else{
                   arr[i][j]=0;
                }
               }else{
               if(matrix[i][j]=='1'){
                   arr[i][j]=arr[i-1][j]+1;
                }else{
                   arr[i][j]=0;
                }
               }
            }
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
         int res=largestRectangleArea(arr[i]);
         ans=ans>res?ans:res;
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] lsn=new int[heights.length];
        int[] rsn=new int[heights.length];
        Arrays.fill(lsn,-1);
        Arrays.fill(rsn,-1);
        Stack<Integer> leftStack=new Stack<>();
        Stack<Integer> rightStack=new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(rightStack.size()==0){
               rightStack.push(i); 
               continue;
            }
            while(rightStack.size()>0 && heights[rightStack.peek()]>heights[i]){
                rsn[rightStack.pop()]=i;
            }
            rightStack.push(i);
        }
        for(int i=heights.length-1;i>=0;i--){
            if(leftStack.size()==0){
               leftStack.push(i); 
               continue;
            }
            while(leftStack.size()>0 && heights[leftStack.peek()]>heights[i]){
                lsn[leftStack.pop()]=i;
            }
            leftStack.push(i);
        }
        int ans=0;
        for(int i=0;i<heights.length;i++){
            if(lsn[i]<0 && rsn[i]<0){
               int width=heights.length;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width); 
            }else if(lsn[i]>=0 && rsn[i]>0){
               int width=(rsn[i]-1)-(lsn[i]+1)+1;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width);
            }else if(lsn[i]>=0 && rsn[i]<0){
               int width=(heights.length-1)-(lsn[i]+1)+1;
               ans=ans>(heights[i]*width)?ans:(heights[i]*width);
            }else{
                int width=rsn[i];
               ans=ans>(heights[i]*width)?ans:(heights[i]*width); 
            }
        }
       return ans;
    }
}