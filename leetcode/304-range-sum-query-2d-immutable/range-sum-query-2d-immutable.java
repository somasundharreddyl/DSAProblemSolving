class NumMatrix {
 
   int[][] prefixSumArr;
    public NumMatrix(int[][] matrix) {
     int row=matrix.length;
     int col=matrix[0].length;
     prefixSumArr=new int[row][col];
      
     for(int i=0;i<row;i++){
         for(int j=0;j<col;j++){
             if(j==0){
           prefixSumArr[i][j]=matrix[i][j];
             }else{
                 prefixSumArr[i][j]=prefixSumArr[i][j-1]+matrix[i][j];
             }
         }
     }

     for(int i=0;i<col;i++){
         for(int j=1;j<row;j++){
             prefixSumArr[j][i]+=prefixSumArr[j-1][i];
         }
     }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=prefixSumArr[row2][col2];
        if(row1-1>=0){
           ans=ans-prefixSumArr[row1-1][col2];
        }
         if(col1-1>=0){
           ans=ans-prefixSumArr[row2][col1-1];
        }
        if(row1-1>=0 && col1-1>=0){
           ans=ans+prefixSumArr[row1-1][col1-1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */