class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans=Integer.MIN_VALUE;
        int[] arr=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
             if(matrix[i][j]=='1'){
                arr[j]++;
             }else{
                arr[j]=0;
             }
            }
            int area=largestRectangleArea(arr);
            ans=ans>area?ans:area;
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] rse=new int[n];
        int[] lse=new int[n];
        Arrays.fill(rse,-1);
        Arrays.fill(lse,-1);
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        st1.push(0);
        for(int i=1;i<n;i++){
           while(st1.size()>0 && heights[st1.peek()]>heights[i]){
            rse[st1.pop()]=i;
           }
           st1.push(i);
        }
        st2.push(n-1);
        for(int i=n-2;i>=0;i--){
           while(st2.size()>0 && heights[st2.peek()]>heights[i]){
            lse[st2.pop()]=i;
           }
           st2.push(i);
        }
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(i==0){
            int w=(rse[i]-1)-i+1;
            if(rse[i]==-1){
                w=n;
            }
            int area=w*heights[i];
            maxArea=maxArea>area?maxArea:area;
            }else if(i==n-1){
            int w=i-(lse[i]+1)+1;
            if(lse[i]==-1){
                w=n;
            }
            int area=w*heights[i];
            maxArea=maxArea>area?maxArea:area;
            }else{
                int w=rse[i]-1-(lse[i]+1)+1;
                if(rse[i]==-1 && lse[i]==-1){
                    w=n;
                }else if(lse[i]==-1){
                  w=rse[i];
                }else if(rse[i]==-1){
                   w=n-1-(lse[i]+1)+1; 
                }
            int area=w*heights[i];
            maxArea=maxArea>area?maxArea:area; 
            }
        }
        return maxArea;
    }
}